<html>
    <head>
	    <meta charset="utf-8"/>
	    <meta name="description" content="IoTemperature"/>
		<meta name="author" content="Juan Daniel Castillo Reyes" />
		<meta name="robots" content="all"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <title>IoTemperature</title>
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/cerulean/bootstrap.min.css"/>
    	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    	<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script type="text/javascript" src="js/layout.js"></script>
		<link rel="stylesheet" type="text/css" href="css/layout.css"/>
    </head>
    <body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">IoTemperature</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="#" id="act"> <span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Actualizar</a></li>
	        <li><a href="#" id="stop"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> Detener</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="row">
		<div class="col-md-1" ></div>
		<div class="col-md-3" >
			<div class="panel panel-info">
			  <div class="panel-heading">
			    <h3 class="panel-title">Ultima temperatura</h3>
			  </div>
			  <div class="panel-body">
			  <ul class="nav nav-pills">
				  <li"><a href="#">Peitición: <span class="badge" id="minuto">1</span></a></li>
				</ul>
			    <p id ="last"></p>
			    <blockquote>
				  <p><b>Nota: </b>Todas las temperaturas se miden en °C y se actualizan cada 5 segundos </p>
				</blockquote>
			  </div>
			</div>
		</div>
		<div class="col-md-7"><div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div></div>
		<div class="col-md-1" ></div>
	</div>
    </body>
</html>
