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
    table.append(`
              <tr class="logged">
              <td>${record.cords}</td>
              <td>${record.time}</td>
              <td>${record.exec}</td>
              <td>${record.result}</td>
            </tr>
  `);
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
}