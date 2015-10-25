<!-- Liens pour Ajax/JSON : 
		http://www.mysamplecode.com/2012/04/jquery-ajax-request-response-java.html
		
 -->

<%@ page import="java.util.Vector" %>
<%@ page import="fr.eni.bean.Promotion, fr.eni.bean.Statut, fr.eni.bean.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestion d'un stagiaire</title>
	
	<link href="css/style.css" rel="stylesheet">
	<link href="css/custom-theme/jquery-ui-1.9.2.custom.css" rel="stylesheet">
	<script src="script/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
	<script src="script/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>	
	
	<style>
	.ui-combobox {
		position: relative;
		display: inline-block;
	}
	.ui-combobox-toggle {
		position: absolute;
		top: 0;
		bottom: 0;
		margin-left: -1px;
		padding: 0;*/
		/* adjust styles for IE 6/7 
		height: 3px;*/
		top: 0px;
	}
	.ui-combobox-input {
		margin: 0;
		padding: 1px;
		
	}*/
	</style>
	<script>
	(function( $ ) {
		$.widget( "ui.combobox", {
			_create: function() {
				var input,
					that = this,
					select = this.element.hide(),
					selected = select.children( ":selected" ),
					value = selected.val() ? selected.text() : "",
					wrapper = this.wrapper = $( "<span>" )
						.addClass( "ui-combobox" )
						.insertAfter( select );

				function removeIfInvalid(element) {
					var value = $( element ).val(),
						matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( value ) + "$", "i" ),
						valid = false;
					select.children( "option" ).each(function() {
						if ( $( this ).text().match( matcher ) ) {
							this.selected = valid = true;
							return false;
						}
					});
					if ( !valid ) {
						// Retire les éléments invalide à la recherche
						$( element )
							.val( "" )
							.attr( "title", value + " aucun résultat" )
							.tooltip( "open" );
						select.val( "" );
						setTimeout(function() {
							input.tooltip( "close" ).attr( "title", "" );
						}, 2500 );
						input.data( "autocomplete" ).term = "";
						return false;
					}
				}

				input = $( "<input>" )
					.appendTo( wrapper )
					.val( value )
					.attr( "title", "" )
					.addClass( "ui-state-default ui-combobox-input" )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: function( request, response ) {
							var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
							response( select.children( "option" ).map(function() {
								var text = $( this ).text();
								if ( this.value && ( !request.term || matcher.test(text) ) )
									return {
										label: text.replace(
											new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" +
												$.ui.autocomplete.escapeRegex(request.term) +
												")(?![^<>]*>)(?![^&;]+;)", "gi"
											), "<strong>$1</strong>" ),
										value: text,
										option: this
									};
							}) );
						},						
						select: function( event, ui ) {
							ui.item.option.selected = true;
							that._trigger( "selected", event, {
								item: ui.item.option								
							});
						},
						// En cas de changeent d'item
						change: function( event, ui ) {
							// Vérifie s'il ait partie des critère de recherche
							if ( !ui.item ){
								return removeIfInvalid( this );
							}
							// Remplit les infos sur le stagiaire
							RemplirInfos(ui.item.value);
						}
					})
					.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};

				$( "<a>" )
					.attr( "tabIndex", -1 )
					.tooltip()
					.appendTo( wrapper )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.removeClass( "ui-corner-all" )
					.addClass( "ui-corner-right ui-combobox-toggle" )
					.click(function() {
						// close if already visible
						if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
							input.autocomplete( "close" );
							removeIfInvalid( input );
							return;
						}

						// work around a bug (likely same cause as #5265)
						$( this ).blur();

						// pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
						input.focus();
					});

					input
						.tooltip({
							position: {
								of: this.button
							},
							tooltipClass: "ui-state-highlight"
						});
			},

			destroy: function() {
				this.wrapper.remove();
				this.element.show();
				$.Widget.prototype.destroy.call( this );
			}
		});
	})( jQuery );
	
	$(function() {
		$( "#listeStagiaire" ).combobox();
		$( "#listeStatut" ).combobox();
		$( "#listePromo" ).combobox();
	});
	
	function RemplirInfos(idStagiaire){
		        
        dataString = "idStagiaire=" + idStagiaire;
        
        //make the AJAX request, dataType is set to json
        //meaning we are expecting JSON data in response from the server
        $.ajax({
            type: "POST",
            url: "/GestionStagiaire",
            data: dataString,
            dataType: "json",
            
            //if received a response from the server
            success: function( data, textStatus, jqXHR) {
                //our country code was correct so we have some information to display
                 if(data.success){
                	 alert("Succes d'ajax");
                 }
                 //display error message
                 else {
                     alert("Erreur dans l'ajax");
                 }
            },
            
            //If there was no resonse from the server
            error: function(jqXHR, textStatus, errorThrown){
                 console.log("Something really bad happened " + textStatus);
                  $("#ajaxResponse").html(jqXHR.responseText);
            },
            
            //capture the request before it was sent to server
            beforeSend: function(jqXHR, settings){
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
                $('#myButton').attr("disabled", true);
            },
            
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function(jqXHR, textStatus){
                //enable the button
                $('#myButton').attr("disabled", false);
            }
  
        });  
		
	}
		
	</script>
	
</head>

<body>

	<%
		Vector<Promotion> listePromo = (Vector<Promotion>) request.getAttribute("listePromo");
		Vector<Statut> listeStatut = (Vector<Statut>) request.getAttribute("listeStatut");
		Vector<Utilisateur> listeStagiaire = (Vector<Utilisateur>) request.getAttribute("listeStagiaire");
		Utilisateur utilisateurSelectionne = null;
		try{
			utilisateurSelectionne = (Utilisateur) request.getAttribute("stagiaireChosi");
			
			if(utilisateurSelectionne == null){
				utilisateurSelectionne = listeStagiaire.get(0);
			}
			
		} catch(Exception e){
			System.out.println("Impossible de mettre les champs à jour suivant le stagiaire choisi (gestion stagiaire)");
			e.printStackTrace();
		}
		
	%>
	
	<select id="listeStagiaire" name="listeStagiaire">
		<%
			for(Utilisateur utilisateur : listeStagiaire){
		%>
				<option id="itemStagiaire" value="<%=utilisateur.getId_user()%>"><%= utilisateur.getPrenom() %> <%= utilisateur.getNom() %></option>
		<%
			}
		%>
	</select>
	<input type="button" value="Nouveau">
			
	<div>
		<form action="<%= request.getContextPath() %>/GestionStagiaire" method="post">
		
			<table>
				<tr>
					<td>Prénom </td>
					<td><input id="prenom" name="prenom" type="text"/></td>
				</tr>
				<tr>
					<td>Nom </td>
					<td><input id="nom" name="nom" type="text"/></td>
				</tr>
				<tr>
					<td>Numéro de promo </td>
					<td>
						<select id="listePromo" name="listePromo">
							<%
								for(Promotion promo : listePromo){
							%>
									<option id="itemPromo" value="<%=promo.getId_promo()%>"><%= promo.getLibelle() %></option>
							<%
								}
							%>
						</select>
					</tr>
				</tr>
				<tr>
					<td>Numéro de statut </td>
					<td>
						<select id="listeStatut" name="listeStatut">
							<%
								for(Statut unStatut : listeStatut){
							%>
									<option id="itemPromo" value="<%= unStatut.getId_statut() %>"><%= unStatut.getLibelle() %></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>Identifiant </td>
					<td><input id="login" name="login" type="text"/></tr>
				</tr>
				<tr>
					<td>Mot de passe </td>
					<td><input id="password" name="password" type="text"/></tr>
				</tr>
				<tr>
					<td>Archivé </td>
					<td><input id="estArchive" name="estArchive" type="checkbox"/></tr>
				</tr>
				<tr>
					<td>Adresse mail </td>
					<td><input id="estArchive" name="estArchive" type="text"/></tr>
				</tr>
			</table>
			
			<input type="submit" value="ValiderOuModifier">
			<input type="submit" value="AnnulerOuSupprimer">
		
		</form>
	</div>
		
</body>
</html>