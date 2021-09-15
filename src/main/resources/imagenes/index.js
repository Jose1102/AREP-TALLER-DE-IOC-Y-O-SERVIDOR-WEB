var txt;
var r = confirm("¿ Deseas volver al menú principal ?");
if (r == true) {
    txt = "You pressed OK!";
    window.location.href = "https://taller-ioc.herokuapp.com/index.html"
} else {
    txt = "You pressed Cancel!";
}
console.log(txt);