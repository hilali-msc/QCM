<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link href="../css/style.css" rel="stylesheet">
	<script src="../script/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
	<script src="../script/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>
	<link href="../css/custom-theme/jquery-ui-1.9.2.custom.css" rel="stylesheet">

	<script>
		$(function() {
			$( "#accordion" ).accordion();
		});
	</script>
	
</head>
<body>
	<%= request.getContextPath() %>
	<div id="accordion">
	<h3>Section 1</h3>
	<div>
		<p>
		Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
		ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
		amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
		odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
		</p>
	</div>
	<h3>Section 2</h3>
	<div>
		<p>
		Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
		purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
		velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
		suscipit faucibus urna.
		</p>
	</div>
	<h3>Section 3</h3>
	<div>
		<p>
		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
		Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
		ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
		lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
		</p>
		<ul>
			<li>List item one</li>
			<li>List item two</li>
			<li>List item three</li>
		</ul>
	</div>
	<h3>Section 4</h3>
	<div>
		<p>
		Cras dictum. Pellentesque habitant morbi tristique senectus et netus
		et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
		faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
		mauris vel est.
		</p>
		<p>
		Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
		Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
		inceptos himenaeos.
		</p>
	</div>
</div>

<div class="demo-description">
<p>
Click headers to expand/collapse content that is broken into logical sections, much like tabs.
Optionally, toggle sections open/closed on mouseover.
</p>
<p>
The underlying HTML markup is a series of headers (H3 tags) and content divs so the content is
usable without JavaScript.
</p>
</div>

</body>
</html>