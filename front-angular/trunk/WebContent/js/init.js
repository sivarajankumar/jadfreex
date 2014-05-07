$(document).ready(
	drawMap
);

function drawMap() {
	//Preparen
    var
	mapa = Raphael('mapa', 800, 500),
	divInfo = $("#info"),
	attr = {
			'stroke-width': 1,
			'stroke': 'green',
			'stroke-linejoin':'round'
	},
    path = null;
	mapa.safari();
	
	//Apunten
	$.get("http://localhost:8080/test-app/rest/map/list", function(paths) {
		paths.forEach(function(estado) {
			//Fuegoooo!!!
	        path = mapa.path(estado.path);
			attr.fill = estado.color;
			path.attr(attr);
	        path.hover(
				function(){
					this.animate({
						fill: 'white',
					}, 100);
					divInfo.html(
						"<h1>"+estado.name+"</h1>" +
						"<p>"+estado.info+"</p>"
					);
				},
				function(){
					this.animate({
						fill: estado.color
					}, 100);
					divInfo.text("");
				}
			);
			path.click(function(){
				location.href = estado.url;
	        });
		});
	});
}

//Carga de datos
//paths.forEach(function(estado) {
//console.log("{nombre: "+estado.name+", path: "+estado.path+"}");
//$.post("http://localhost:8080/test-app/rest/map/add", {nombre: estado.name, path: estado.path});
//});