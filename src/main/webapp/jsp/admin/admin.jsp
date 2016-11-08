<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!--<script type="text/javascript">
        var homeJsonresponse=${homeJsonresponse}; 
 </script>-->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"
	xmlns:og="http://ogp.me/ns#"
	xmlns:fb="http://www.facebook.com/2008/fbml" itemscope
	itemtype="http://schema.org/Organization">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache,no-store" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" type="text/css" href="./resources/styles/quiz.css" media="all"/>
</head>
<body>
<div id="header"><tiles:insertAttribute name="adminHeader" /></div>
<div id="nav"><tiles:insertAttribute name="navQuiz" /></div>
<div id="hero"><tiles:insertAttribute name="hero" /></div>
<div id="maincontent"><tiles:insertAttribute name="quizContent" /></div>
<div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>