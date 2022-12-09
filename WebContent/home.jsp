<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Article - UIkit 3 KickOff</title>
		<link rel="icon" href="img/favicon.ico">
		<!-- CSS FILES -->
		<link rel="stylesheet" type="text/css" href="vendor/uikit/css/uikit.min.css">
		<style>
		.uk-container-small {
		max-width: 47rem;
		}
		</style>
	</head>
	<body>
		<!--HEADER-->
		<header style="background-color: #fff; border-bottom: 1px solid #f2f2f2" data-uk-sticky="show-on-up: true; animation: uk-animation-slide-top">
			<div class="uk-container">
				<nav id="navbar" data-uk-navbar="mode: click;">

					<div class="uk-navbar-center">
						<a class="uk-navbar-item uk-logo" href="#">Logo</a>
					</div>
				</nav>
			</div>
		</header>
		<!--/HEADER-->

        <!-- CONTENU / MILIEU -->
		<section class="uk-section">
			<div class="uk-container uk-container-small">

                <h1 class="uk-heading-small">Accueil</h1>

                <p uk-margin><a class="uk-button uk-button-default" href="/SuiviRepas/add-meal">Ajouter un nouveau Repas</a></p>
                <p uk-margin><a class="uk-button uk-button-default" href="/SuiviRepas/show-meal">Visualiser les repas</a></p>

            </div>
        </section>
        <!-- /CONTENU / MILIEU -->

		<!--FOOTER-->
		<footer class="uk-section uk-section-small" style="margin-bottom: 60px">
			<div class="uk-container">
				<p class="uk-text-small uk-text-center">Copyright 2019 - <a href="https://github.com/zzseba78/Kick-Off">Created by KickOff</a> | Built with <a href="http://getuikit.com" title="Visit UIkit 3 site" target="_blank" data-uk-tooltip><span data-uk-icon="uikit"></span></a> </p>
			</div>
		</footer>
		<!--/FOOTER-->
		
		<!-- OFFCANVAS -->
		<div id="offcanvas-nav" data-uk-offcanvas="flip: true; overlay: true">
			<div class="uk-offcanvas-bar uk-offcanvas-bar-animation uk-offcanvas-slide">
				<button class="uk-offcanvas-close uk-close uk-icon" type="button" data-uk-close></button>
				<ul class="uk-nav uk-nav-default">
					<li class="uk-active"><a href="#">Active</a></li>
					<li class="uk-parent">
						<a href="#">Parent</a>
						<ul class="uk-nav-sub">
							<li><a href="#">Sub item</a></li>
							<li><a href="#">Sub item</a></li>
						</ul>
					</li>
					<li class="uk-nav-header">Header</li>
					<li><a href="#js-options"><span class="uk-margin-small-right uk-icon" data-uk-icon="icon: table"></span> Item</a></li>
					<li><a href="#"><span class="uk-margin-small-right uk-icon" data-uk-icon="icon: thumbnails"></span> Item</a></li>
					<li class="uk-nav-divider"></li>
					<li><a href="#"><span class="uk-margin-small-right uk-icon" data-uk-icon="icon: trash"></span> Item</a></li>
				</ul>
				<h3>Title</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
		</div>
		<!-- /OFFCANVAS -->
		
		<!-- JS FILES -->
		<script src="vendor/uikit/js/uikit.min.js"></script>
		<script src="vendor/uikit/js/uikit-icons.min.js"></script>
		
	</body>
</html>
