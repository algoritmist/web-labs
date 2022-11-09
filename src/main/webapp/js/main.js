import {
    loadRecords, appendRecord, saveRecord, clearStorage
} from "./cookies.js";

$(function () {
    loadRecords();
});

function checkTextY(val) {
    return (val >= -3 && val <= 5);
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

    ajax: {
        if (checks.length == 0) break ajax;
        if (isNaN(text) || !checkTextY(text)) break ajax;
        if (isNaN(radio)) break ajax;

        checks.forEach(box => {
            $.ajax({
                url: './check',
                method: 'get',
                dataType: 'json',
                data: {
                    TYPE: "AREACHECK",
                    x: box,
                    y: text,
                    r: radio,
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
        });
    }
});

$("#clear-button").click(function () {
    clearStorage();
});