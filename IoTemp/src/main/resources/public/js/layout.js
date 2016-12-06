var repeater;
var temp = [];
var limit = 10;
var minuto = 0;
$(function () {
	ajaxCall();
	$('#act').on('click', function(e){
		e.preventDefault();
		ajaxCall();
	});
});

function printChart(){
    Highcharts.chart('container', {
        chart: {
            type: 'area'
        },
        title: {
            text: 'Temperatura'
        },
        subtitle: {
            text: '¡La temperatura ahora!'
        },
        xAxis: {
            allowDecimals: false,
            labels: {
                formatter: function () {
                    return this.value;
                }
            }, title:{
            	text: 'Tiempo en segundos'
            }
        },
        yAxis: {
            title: {
                text: 'Grados centigrados ° C'
            },
            labels: {
                formatter: function () {
                    return this.value;
                }
            }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y:,.0f} °C</b> hace {point.x} segundos'
        },
        plotOptions: {
            area: {
                pointStart: 0,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        },
        series: [{
            name: 'Temperatura',
            data: temp,
            color: '#ffa500'
        }]
    });
}
function ajaxCall(){
	 $.ajax({
	        url:"/temp/"+limit,
	        success:function(data,textStatus,xhr){
	        	temp = data.split(',');
	        	temp.pop();
	        	temp = temp.map(Number);
	        	console.log(temp);
	        	printChart();
	        	limit = limit +10;
	        	minuto = minuto +1;
	        	$('#last').html("<span class='glyphicon glyphicon-fire' aria-hidden='true'></span>"+temp[0]);
	        	$('#minuto').html(minuto);
	        	$('#stop').click(function(){
	        		stopAjax();
	        	});
	        	repeater = setTimeout(ajaxCall, 5000);
	        }
	      });
}
function stopAjax(){
	clearTimeout(repeater);
}