const url = "https://countriesnow.space/api/v0.1/countries/states";
const countrySelect = $("#country");
const stateSelect = $("#state");
// send get request to url and get response using jquery
let data = {};
$.get(url, function (d) {
    for (item of d.data) {
        data[item.name] = item.states.map((state) => state.name);
    }
    for (let country in data) {
        countrySelect.append(
            `<option value="${country}" ${
                country === "Tunisia" ? "selected" : null
            } >${country}</option>`
        );
    }
    createStateOptions(data["Tunisia"]);
});

// create options for stateSelect with cities from data
function createStateOptions(states) {
    stateSelect.empty();
    for (let state of states) {
        stateSelect.append(`<option value="${state}">${state}</option>`);
    }
}

// add event listener to countrySelect
countrySelect.on("change", function () {
    let states = data[this.value];
    createStateOptions(states);
});
