import {
    loadRecords, appendRecord, saveRecord, clearStorage
} from "./cookies.js";

const SVG_SIZE = 300;
const R = 3;

$(function () {
    loadRecords();
});

function checkTextY(val) {
    return (val >= -3 && val <= 3);
}

$("#y-textinput").on("input", function () {
    let val = parseInt(this.value);
    if (isNaN(val)) {
        this.style.background = "#ffffff";
    } else {
        if (checkTextY(val)) {
            this.style.background = "#00C800B2";
        } else {
            this.style.background = "#C80000B2";
        }
    }
});

$("#submit").click(function () {
    //checkboxest
    const checks = $(".x-check:checked").map(function () {
        return parseInt(this.value);
    }).get();
    //text
    const text = parseInt($("#y-textinput").val());
    //radio
    const radio = parseInt($(".r-radio-check:checked").val());

    checks.forEach(box => {
       doRequest(box, text, radio)
    });

});

$("#clear-button").click(function () {
    clearStorage();
});

$('#graph').mousedown(function (e) {
    alert("pressed the graph");
    const position = $('#graph-wrapper').offset();
    const rowX = e.pageX - position.left;
    const rowY = e.pageY - position.top;

    const x = (((R / 50) * (SVG_SIZE / 2 - rowX) * -1) / 2).toFixed(2);
    const y = (((R / 50) * (SVG_SIZE / 2 - rowY)) / 2).toFixed(2);

    doRequest(x, y, R);
});

function doRequest(X, Y, R) {
    ajax: {
        if (isNaN(text) || !checkTextY(text)) break ajax;
        if (isNaN(radio)) break ajax;
        $.ajax({
            url: './check',
            method: 'get',
            dataType: 'json',
            data: {
                TYPE: "AREACHECK",
                x: X,
                y: Y,
                r: R,
                timezone: new Date().getTimezoneOffset()
            },
            success: function (record) {
                //alert(record);
                saveRecord(record);
                appendRecord(record);
            },
            error: function () {
                console.log("Nooo, PHP error!!!");
            }
        });
    }
}