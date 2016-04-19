/**
 * Created by xavierbarrufet on 16/4/16.
 */


var sampleData = function() {


    var visit1 = {
        gardenId: "111-222-333",
        visitDay: new Date("2015/11/20"),
        type: "STANDARD",
        description: "Visita semanal",
        image: "",
        conversationId: String,
        geoCheck: true,
        services: ["Poda setos", "Limpieza hojas"]

    }

    var visit2 = {
        gardenId: "111-222-333",
        visitDay: new Date("2015/11/18"),
        type: "EXTRA",
        description: "Vaso flores",
        image: "",
        conversationId: String,
        geoCheck: false,
        services: ["Plantacion vaso flores"]

    }

    var visit3 = {
        gardenId: "111-222-333",
        visitDay: new Date("2015/11/16"),
        type: "EXTRA",
        description: "Preparacion Boda",
        image: "",
        conversationId: String,
        geoCheck: true,
        services: ["instalar luces","arreglos florales"]

    }

    return {
        visit2: visit2,
        visit1: visit1,
        visit3: visit3
    }

}();

module.exports = sampleData;

