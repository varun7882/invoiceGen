/**
 * 
 */
console.log("Js loaded");
var listItems=[];
function addItemToList(){
	console.log("Adding to table");
	var tablebody = document.getElementById("tableBody");
	
    var row = tablebody.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    cell1.innerHTML = document.getElementById("pname").value;
    cell2.innerHTML = document.getElementById("pQuant").value;
    cell3.innerHTML = document.getElementById("pcat").value;
    cell4.innerHTML = document.getElementById("price").value;
    cell5.innerHTML =document.getElementById("ptax").value;
    document.getElementById("pname").value="";
    document.getElementById("pQuant").value="";
    document.getElementById("pcat").value="";
    document.getElementById("price").value="";
    document.getElementById("ptax").value="";
    var item={name:cell1.innerHTML,quantity:parseInt(cell2.innerHTML),category:cell3.innerHTML,price:parseFloat(cell4.innerHTML),taxRate:parseFloat(cell5.innerHTML)}
    listItems.push(item);
}
function ajax_post(url, callback,invDetails) {
	console.log("hey")
	var xhr = new XMLHttpRequest();
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        var json = JSON.parse(xhr.responseText);
	        displayInvoice(json)
	    }
	};
	xhr.send(invDetails);
}
function displayInvoice(genInvoice)
{
	y=genInvoice;
	console.log(genInvoice);
	console.log("Adding to Invoicetable");
	var tablebody = document.getElementById("tableBodyInvoice");

	for(var i=0;i<genInvoice["inv"]["listItems"].length;i++)
	{
    var row = tablebody.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    cell1.innerHTML =genInvoice["inv"]["listItems"][i].name
    cell2.innerHTML = genInvoice["inv"]["listItems"][i].quantity
    cell3.innerHTML = genInvoice["pricesWithTax"][i];
	}
	document.getElementById("sum").innerHTML=genInvoice["totalBill"];
}
var x,y;
function getInvoice()
{
	console.log("invoice");
	var invDetails={listItems:listItems,paidBy:document.getElementById("paidBy").value,generatedOn:""}
	x=y=invDetails;
	var url="http://localhost:8080//invoice/generate";
	ajax_post(url,displayInvoice,JSON.stringify(invDetails))
}
