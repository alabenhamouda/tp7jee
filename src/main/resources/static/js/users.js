$(function () {
    $(".clickable").click(function () {
        const id = $(this).data("id");
        window.location = `/${id}`;
    });
});
