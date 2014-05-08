function Map($scope, $http) {
	//Declaración de variables
    var
	mapa = Raphael('mapa', 800, 450),
	attr = {
			'stroke-width': 1,
			'stroke': 'green',
			'stroke-linejoin':'round'
	},
    path = null;
    
	mapa.safari();
	
	//GET
    $http({method: 'GET', url: 'http://localhost:8080/test-app/rest/map/list'}).
        success(function(paths) {
        	//$scope.greeting = data;
        	paths.forEach(function(estado) {
    	        path = mapa.path(estado.path);
    			attr.fill = estado.color;
    			path.attr(attr);
    	        path.hover(
    				function(){
    					this.animate({
    						fill: 'greenyellow',
    					}, 100);
    				},
    				function(){
    					this.animate({
    						fill: estado.color
    					}, 100);
    				}
    			);
    			path.click(function(){
    				Info($scope, $http, estado.id);
    	        });
    		});
        }).
        error(function(){
        	alert("Josefuck dice: Tu aplicación esta mal! Pinche chavo! ¬¬");
        });
}