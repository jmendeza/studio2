<#include "/templates/system/common/cstudio-support.ftl" />
<#include "/templates/web/navigation/navigation.ftl">

<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="utf-8">
    <title>Rosie Rivet - Crafter Rivet Demo Site</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Rivet Logic Corporation">

    <link href="/static-assets/css/main.css" rel="stylesheet">
    
    <script src="/static-assets/js/jquery.core.js" ></script>
    
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div id="main-container" class="product-page">

<#include "/templates/web/fragments/header.ftl"/>

<div class="container-fluid" id="content-body">
    
    <div class="row-fluid">
        <div class="span3 mb10" id="site-nav">
        
        	<div class="input-append" id="site-search">
	        	<input type="text" class="wauto" placeholder="search" />
	        	<a class="add-on">
		        	<i class="icon icon-search"></i>
	        	</a>
        	</div>
            
			<ul class="nav nav-list amaranth uppercase">
				<@renderNavigation "/site/website", 1 />	
			</ul>
            
        </div>
        <div class="span9" id="content">
          <h1>${model.tile}</h1>
          
          <@ice id="abstract"/>
          ${model.abstract}    

			<input id="s" value="hello world abc" /><button id="submit">Submit</button>
			<br/>
			<div id='example'>
			</div>

			<script>
			jQuery("#submit").click(function() {

					jQuery.ajax({  
			            type: "get",
			        	data: "?s=" + jQuery("#s").val(),
			        	url: "/proxy/democom/acme/allcaps",
			        	success:function(data) {
			         		jQuery('#example').html(data); 
			         	}
			           });  

			});

			</script>

</div>


</div>

    <hr>
<#include "/templates/web/fragments/footer.ftl"/>
</div>
<!-- /container -->


</div>

<script src="/static-assets/js/jquery.min.js"></script>
<script src="/static-assets/js/bootstrap.min.js"></script>
<script src="/static-assets/js/main.js"></script>
<@cstudioOverlaySupport/>

</body>
</html>