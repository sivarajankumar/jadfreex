function Info($scope, $http, id) {
	//GET
    $http({method: 'GET', url: 'http://localhost:8080/test-app/rest/map/get/'+id}).
        success(function(datos) {
        	(function (div) {
				Flotr.draw(
					div,
					[datos]
				);
			})(document.getElementById("info"));
        }).
        error(function(){
        	alert("Dr. Josefuck dice: Tu aplicación esta mal! Pinche chavo! ¬¬");
        });
}