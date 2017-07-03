var param = {};
var map = null;
var latitude = 0;
var longitude = 0;

//
var latlngs = [];
var markerList = [];

$(document).ready(function() {
	navGeo();

	$("#searchBtn").click(function() {
		search();
	});
	
	search();
	
	
});

function hideBtn() {
	$("#lstDiv").css("display", "none");
	$("#map").css("width", "100%");
	$("#hideBtn").css("display", "none");
	$("#listBtn").css("display", "inline-block");
}

function listBtn() {
	$("#lstDiv").css("display", "inline-block");
	$("#map").css("width", "49%");
	$("#hideBtn").css("display", "inline-block");
	$("#listBtn").css("display", "none");
	
}

function search() {
	navGeo();

	param = {};
	param.latitude = $("#latitude").val();
	param.longitude = $("#longitude").val();
	param.dgsbjtCd = $("#dgsbjtCd").val();// 진료과목

	// alert(param.dgsbjtCd);

	// 본사 고정(좌표 없을시)
	if(latitude == "0")
		param.latitude = "37.4907489";
	if(longitude == "0")
		param.longitude = "127.0314723";
	
	$.ajax({
		type : "POST",
		url : "/ladaka/hospitalSearchAjax",
		data : param,
		dataType : "json",
		success : parseJson,
		error : function() {
			alert("error!!");
		}
	});

}

function parseJson(data) {
	var html = "";

	// alert(data.response.body.totalCount);
	/*
	 * $("#span").html(data.response.body.pageNo+"/"+data.response.body.totalCount);
	 */
	var distance = 0;
	var distanceDis = "";
	
	initMap();// 지도 초기화
	latlngs = [];
	markerList = [];
	
	$.each(data.result, function(index, entry) {
		distance = Number(entry["DISTANCE"]);
		if (distance >= 1)
			distanceDis = distance.toFixed(2) + "km";
		else {
			distance = distance * 1000;
			distanceDis = distance.toFixed(0) + "m";
		}
		var no = index + 1;
		html += "<div class='hospitalList' x='" + entry["Y_POS"] + "' y='" + entry["X_POS"] + "' h-name='" + entry["YADM_NM"] + "' style='border-top:1px solid blue; border-bottom:1px solid blue; border-left:1px solid blue; border-right:1px solid blue; padding:10px;'>";
		html += no + ". " + entry["YADM_NM"];
		html += "<br/>";
		html += distanceDis;
		html += " | ";
		html += entry["SGGU_CD_NM"] + " " + entry["EMDONG_NM"];
		//html += "<br/>";
		//html += entry["X_POS"] + "/" + entry["Y_POS"];
		html += "</div>";
		
		//makerMap(entry["Y_POS"], entry["X_POS"]);
		latlngs.push(new naver.maps.LatLng(entry["Y_POS"], entry["X_POS"]));
	});
	// $("#listTd").html(html);
	$("#lstDiv").html(html);

	// page
	html = "";

	initBtn();
	initBtn2();//마커찍기 10개
}

//지도 정보창
var HOME_PATH = window.HOME_PATH || '.';

var infowindow = new naver.maps.InfoWindow({});
function info(item, x, y) {
	var target = new naver.maps.LatLng(x, y),
		/*
		map = new naver.maps.Map('map', {
			center: target.destinationPoint(0, 500),
			zoom: 10
		}),
		*/
		marker = new naver.maps.Marker({
			map: map,
			position: target
		});
		
	var contentString = [
		'<div class="iw_inner22">',
		'    <h3>'+$(item).attr("h-name")+'</h3>',
		'    <p>X점, X명</p>',
		'</div>'
	].join('');
	
	infowindow = new naver.maps.InfoWindow({
		content: contentString
	});
	
	infowindow.open(map, marker);
}
//지도 정보창 end

function navGeo(x, y) {
	if (navigator.geolocation) {
		// geolocation is available
		navigator.geolocation.getCurrentPosition(showMap);
		function showMap(position) {
			latitude = position.coords.latitude;
			longitude = position.coords.longitude;
			
			$("#latitude").val(latitude);
			$("#longitude").val(longitude);
		}
	} else {
		alert("I'm sorry, but geolocation services are not supported by your browser.");
	}
}

function initBtn() {//버튼 연결
	$(".hospitalList").click(function() {
		$(".hospitalList").css("background-color", "#FFFFFF");
		$(this).css("background-color", "#FFFFF0");
		
		info(this, $(this).attr("x"), $(this).attr("y"));
		moveMap($(this).attr("x"), $(this).attr("y"));
	});
}

function initBtn2() {
	var HOME_PATH = window.HOME_PATH || '.';
	
	for (var i = 0, ii = latlngs.length; i < ii; i++) {
		var icon = {
			url : HOME_PATH + '/images/map/sp_pins_spot_v3.png',
			size : new naver.maps.Size(24, 37),
			anchor : new naver.maps.Point(12, 37),
			origin : new naver.maps.Point(i * 29, 0)
		}, marker = new naver.maps.Marker({
			position : latlngs[i],
			map : map,
			icon : icon
			/*
			,
			shadow : {
				url : HOME_PATH + '/images/map/shadow-pin_default.png',
				size : new naver.maps.Size(40, 35),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(11, 35)
			}
			*/
		});
		
		marker.set('seq', i);
		
		markerList.push(marker);
		
		// marker.addListener('mouseover', onMouseOver);
		// marker.addListener('mouseout', onMouseOut);
		
		//마커클릭 이벤트
		naver.maps.Event.addListener(marker, "click", function(e) {
			//alert("클릭");
		});
		
		icon = null;
		marker = null;
	}
}

// 네이버 지도
function initMap() {
	var mapOptions = {
		center : new naver.maps.LatLng(latitude, longitude),
		zoom : 11
	};
	map = new naver.maps.Map('map', mapOptions);
	
	makerMapMy(latitude, longitude);
}

function moveMap(x, y) {
	// e.preventDefault();
	var target = new naver.maps.LatLng(x, y);
	map.setCenter(target);
}

// 네이버 지도 마커
function makerMapMy(x, y) {
	var marker = new naver.maps.Marker({
		position : new naver.maps.LatLng(x, y),
		map : map,
		icon : {
			url : 'images/map/ico_pin.jpg',
			size : new naver.maps.Size(25, 34),
			scaledSize : new naver.maps.Size(25, 34),
			origin : new naver.maps.Point(0, 0),
			anchor : new naver.maps.Point(12, 34)
		}
	});
	
	
	
}

function makerMap(x, y) {
	var marker = new naver.maps.Marker({
		position : new naver.maps.LatLng(x, y),
		map : map,
		icon : {
			url : 'images/map/maker_blue.png',
			size : new naver.maps.Size(22, 33),
			scaledSize : new naver.maps.Size(22, 33),
			origin : new naver.maps.Point(0, 0),
			anchor : new naver.maps.Point(12, 34)
		}
		
	});
}

