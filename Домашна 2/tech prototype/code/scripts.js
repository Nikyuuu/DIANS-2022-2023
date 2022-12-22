
let L = window.L;

let map = L.map('map', {
    center: [42.0020,21.4032],
    zoom: 14,
    gestureHandling: true
});


L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,

    //attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);




function val() {
    return document.getElementById("banks").value;
}

let bankArr = [];

getData();
async function getData(){
    const response = await fetch('test.csv');
    const data = await response.text();


    const table = data.split('\n').splice(1);

    for(let i =0;i<bankArr.length;i++){
        map.removeLayer(bankArr[i])
    }
    bankArr = []

    table.forEach(row =>{
        const columns = row.split(',');
        const longitude = columns[6];
        const longitudeCord = parseFloat(longitude);
        const latitude = columns[7];
        const latitudeCord = parseFloat(latitude);
        const nameBanks = columns[2].split(" ")[0];


        if(nameBanks.toLowerCase() === val()){
            let marker = L.marker([latitudeCord,longitudeCord]);
            map.addLayer(marker);
            marker.bindPopup(nameBanks);

            bankArr.push(marker);
        }
    })

}
