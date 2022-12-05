const SVG_SIZE = 300;

export function loadRecords() {
    const storage = localStorage.getItem("storage");
    if (storage == null) {
        localStorage.setItem("storage", '{"object": []}');
    } else {
        JSON.parse(storage).object.forEach(element => {
            appendRecord(element);
        });
    }
}

export function appendRecord(record) {
    let table = $(".table-container tbody");

    let rX = record.result.point.x;
    let rY = record.result.point.y;
    let rR = record.result.r;
    let rHit = record.result.hit;

    table.append(`
              <tr class="logged">
              <td>${"(" + [rX, rY, rR] + ")"}</td>
              <td>${record.currentTime}</td>
              <td>${record.workingTime}</td>
              <td>${rHit == true ? "Попадание" : "Промах"}</td>
            </tr>
  `);
    let svg = $("#graph");
    let x = ((SVG_SIZE / 2 + rX / rR * 100));
    let y = ((SVG_SIZE / 2 + rY / rR * -100));
    let color = rHit == true ? "blue" : "red";

    function makeSVG(tag, attrs) {
        let el = document.createElementNS('http://www.w3.org/2000/svg', tag);
        for (let k in attrs)
            el.setAttribute(k, attrs[k]);
        return el;
    }


    let circle = makeSVG('circle', {cx: x, cy: y, r: 4, fill: color});
    console.log(circle);
    svg.append(circle);
}

export function saveRecord(record) {
    const storage = localStorage.getItem("storage");
    const objStor = JSON.parse(storage);
    objStor.object.push(record);
    console.log(objStor);
    localStorage.setItem("storage", JSON.stringify(objStor));
}

export function clearStorage() {
    localStorage.setItem("storage", '{"object": []}');
    let table = $(".table-container tbody");
    table.empty();
    $("#graph circle").remove();
}