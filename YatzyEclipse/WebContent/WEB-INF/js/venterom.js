
/**
 * Laster inn -> Venter på spillere
 */
function loader() {

}

function printUtSpillere (x ) {
var Spillere = ["JanW", "VilH", "BalT", "Reggis", "Anus", "Ema"];
var tekst = "";
for (var i in Spillere) {
  if (i ==  0) {
    tekst += "<p class='posisjon0'>";
    tekst += Spillere[i];
    tekst += "</p>";
    }
  if (i == 1) {
    tekst += "<p class='posisjon1'>";
    tekst += Spillere[i];
    tekst += "</p>";
    tekst += "<button id='kast' class='posisjon1Knapp kastutbutton kastutbutton:hover' value='Spiller1' onclick='kastUtSpiller()'>Kast ut</button>"
  }
  if (i == 2) {
    tekst += "<p class='posisjon2'>";
    tekst += Spillere[i];
    tekst += "</p>";
    tekst += "<button id='kast' class='posisjon2Knapp kastutbutton kasutbutton:hover' value='Spiller2' onclick='kastUtSpiller()'>Kast ut</button>"
  }
  if (i == 3) {
    tekst += "<p class='posisjon3'>";
    tekst += Spillere[i];
    tekst += "</p>";
    tekst += "<button id='kast' class='posisjon3Knapp kastutbutton kasutbutton:hover' value='Spiller3' onclick='kastUtSpiller()'>Kast ut</button>"
  }
  if (i == 4) {
    tekst += "<p class='posisjon4'>";
    tekst += Spillere[i];
    tekst += "</p>";
    tekst += "<button id='kast' class='posisjon4Knapp kastutbutton kastutbutton:hover' value='Spiller4' onclick='kastUtSpiller()'>Kast ut</button>"
  }
  if (i == 5) {
    tekst += "<p class='posisjon5'>";
    tekst += Spillere[i];
    tekst += "</p>";
    tekst += "<button id='kast' class='posisjon5Knapp kastutbutton kastutbutton:hover' value='Spiller5' onclick='kastUtSpiller()'>Kast ut</button>"
  }
}
  document.getElementById("print").innerHTML += tekst;
  
}


/**
 * Kan kaste ut spiller hvis oenskelig
 */
 function kastUtSpiller () {
  var kasteSpiller = document.getElementById("kast").innerHTML = "slettet";
  alert("kastet ut spiller " + kasteSpiller);
}

function refresh() {
  window .location.reload();
}

function mp_GetData() {
  $.ajax({
    type: "POST",
    url: "Default.aspx/GetData",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    error: function (jqXHR, sStatus, sErrorThrown) {
      alert( 'data:  ' + sErrorThrown);
      alert( 'Get Data Error:  ' + sStatus);
  },
  success: function (data) {
      $("#oTable").empty();
      var oTable = data.d;
      for (i = 0; i <= oTable.Rows.length - 1; i++) {
          $("#oTable").append("<tr><td>" + oTable.Rows[i].lTaskID + "</td><td>" + oTable.Rows[i].sDescription + "</td><td>" + new Date(parseInt(oTable.Rows[i].dtStartDate.substr(6))) + "</td><td>" + new Date(parseInt(oTable.Rows[i].dtEndDate.substr(6))) + "</td></tr>");
      }
  }
});
}
