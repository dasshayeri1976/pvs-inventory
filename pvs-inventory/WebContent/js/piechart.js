/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var chart;
var legend;
// xmlDoc = loadXMLDoc("xml/skill_questions1.xml");
// var x01 = xmlDoc.getElementsByTagName('question');
// var x02 = xmlDoc.getElementsByTagName('response');
// var x03 = xmlDoc.getElementsByTagName('answer');
// var storedNames = JSON.parse(sessionStorage["names"]);
// var k = sessionStorage.getItem("pannel");

function piechartcreate() {

	var chartData = [];
	var legendData = [];

	$.ajax({
		type : "POST",
		async : false,
		url : './Body/Dashboard/chartdata.jsp',
		//url : 'http://localhost:8080/bossmivision/Body/Dashboard/chartdata.jsp',
		// dataType: "json",
		cache : false,
		success : function(json) {
			// fine

			chartData = json;

		},
		error : function() {
			// too bad
			alert("Error");
		}
	});

	// }

	var colors = new Array(4);
	for (i = 0; i < 4; i++) {

		if (i === 0) {
			colors[i] = "#FBCCCC";
			var x = "New";

			legendData.push({
				title : x,
				color : colors[i]
			});
		}

		if (i === 1) {
			colors[i] = "#F4F1B0";
			var x = "Collection";

			legendData.push({
				title : x,
				color : colors[i]
			});
		}

		if (i === 2) {
			colors[i] = "#BEF398";
			var x = "Due";
			legendData.push({
				title : x,
				color : colors[i]
			});
		}
		
		if (i === 3) {
			colors[i] = "#A6ECF7";
			var x = "Dis-connect";
			legendData.push({
				title : x,
				color : colors[i]
			});
		}

	}

	// var colors = ["#FBCCCC", "#F4F1B0", "#A6ECF7", "#BEF398"];
	chart = new AmCharts.AmPieChart();
	chart.dataProvider = chartData;
	chart.titleField = "country";
	chart.valueField = "litres";
	chart.colors = colors;

	// LEGEND
	legend = new AmCharts.AmLegend();
	legend.data = legendData;
	legend.align = "center";
	legend.markerType = "circle";
	chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
	chart.addLegend(legend);

	// WRITE
	chart.write("chartdiv");
	// result();
}
/*
 * function result() {
 * 
 * var k = sessionStorage.getItem("pannel"); for (i = 0; i < k; i++) {
 * if(storedNames[i]<=x03[0].getElementsByTagName("section")[i].childNodes[0].nodeValue) {
 * $("#result").append('<div id="div-' + (i + 1) + '" style="width:98%;
 * background-image:url(Image/p' + (i + 1) + '.png); padding:5px; color:#000;
 * font-size:12px;margin:3px;" align="left"><div
 * style="position;relative;display:table; padding:15px" ><p id="div2-' + (i + 1) + '" align="justify"></p><ol type="a" id="u' + (i + 1) + '" style="padding:5px;padding-left:45px;"></ol></div></div>');
 * 
 * document.getElementById("div2-" + (i + 1)).innerHTML =
 * x02[i].getElementsByTagName("heading")[0].childNodes[0].nodeValue;
 * 
 * for (j = 0; j < x02[i].getElementsByTagName("p").length; j++) {
 * 
 * $("#u" + (i + 1)).append('<li style="padding:10px;align="justify">' +
 * x02[i].getElementsByTagName("p")[j].childNodes[0].nodeValue + '</li>'); } }
 * else { $("#result").append('<div id="div-' + (i + 1) + '" style="width:98%;
 * background-image:url(Image/p' + (i + 1) + '.png); padding:5px; color:#000;
 * font-size:12px;margin:3px;" align="left"><div
 * style="position;relative;display:table; padding:15px" ><p id="div2-' + (i + 1) + '" align="justify"></p><ul id="u' + (i + 1) + '" style="padding:5px;padding-left:25px;"></ul></div></div>');
 * 
 * document.getElementById("div2-" + (i + 1)).innerHTML = "";
 *  } } $("#container").css('height', ($("#container").height() + 70)); }
 */

function setLabelPosition() {
	if (document.getElementById("rb1").checked) {
		chart.labelRadius = 30;
		chart.labelText = "[[title]]: [[value]]";
	} else {
		chart.labelRadius = -30;
		chart.labelText = "[[percents]]%";
	}
	chart.validateNow();
}

function set3D() {
	if (document.getElementById("rb3").checked) {
		chart.depth3D = 10;
		chart.angle = 10;
	} else {
		chart.depth3D = 0;
		chart.angle = 0;
	}
	chart.validateNow();
}

function setSwitch() {
	if (document.getElementById("rb5").checked) {
		legend.switchType = "x";
	} else {
		legend.switchType = "v";
	}
	legend.validateNow();
}