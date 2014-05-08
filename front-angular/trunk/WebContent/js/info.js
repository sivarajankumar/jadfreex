function Info($scope, $http, id) {
	//GET
    $http({method: 'GET', url: 'http://localhost:8080/test-app/rest/map/get/'+id}).
        success(function(datos) {
        	//Flotr2
        	(function (div) {
				Flotr.draw(
					div,
					[datos]
				);
			})(document.getElementById("flotr2"));

        	//jqPlot
        	$("#jqplot").html("");
			$.jqplot('jqplot', datos,
				{
					axes:{
						yaxis:{
							renderer: $.jqplot.LogAxisRenderer,
							tickDistribution:'power'
						}
					},
					series:[{color:'#5FAB78'}]
				}
			);
        }).
        error(function(){
        	alert("Dr. Josefuck dice: Tu aplicación esta mal! Pinche chavo! ¬¬");
        });
}