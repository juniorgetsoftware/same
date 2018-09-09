$(document).ready(
		function() {
			$('.js-toggle').bind("click", function(event) {
				$('.js-sidebar, .js-content').toggleClass('is-toggled');
				event.preventDefault();
			});

			$('.app-ano-atual').html(
					'Todos os direitos reservados - @GetSoftware - '
							+ new Date().getFullYear());
			configurarMoeda();
			configurarInteiro();
		});

$(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() != 0) {
			$('#toTop').fadeIn();
		} else {
			$('#toTop').fadeOut();
		}
	});
	$('#toTop').click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 800);
	});
});

function goToTop() {
	$('html, body').animate({
		scrollTop : 0
	}, 'fast');
}

function configurarMoeda() {
	$(".moeda").maskMoney({
		decimal : ",",
		thousands : "",
		allowZero : true
	});
}

function configurarInteiro() {
	$(".inteiro").maskMoney({
		decimal : "",
		thousands : "",
		allowZero : false
	});
}