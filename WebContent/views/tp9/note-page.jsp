<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/views/template/page-begin.jsp"></jsp:include>

<h1>Accueil</h1>

	<div id="loading-spinner" style="display: none">
		<span id="loading-spinner" uk-spinner="ratio: 4.5"></span>
		<p>Chargement en cours</p>
	</div>
	
	<!-- Le Contenu de la page -->
	<div id="page-content">
		<div id="ListView">
		</div>
	</div>
	
</div>

<form id="form-note" class="uk-form-control">
    <fieldset class="uk-fieldset">

        <legend class="uk-legend">Ajouter une note</legend>
        
	    <div class="uk-margin">
	        <label class="uk-form-label" for="form-stacked-text">Note</label>
			<input  class="uk-input" type="text" name="details">
		</div>
	    <div class="uk-margin">
			<input type="button" id="BtnWebservice" class="uk-button uk-button-default" value="Appeler le Web Service" />
		</div>
	</fieldset>
</form>

	


<!-- Import JQUERY -->
<script src="https://code.jquery.com/jquery-3.6.2.min.js"
  integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA="
  crossorigin="anonymous"></script>

<!-- Utiliser du JS /JQUERY	 -->  
<script>
// Quand la page est prête (jquery)
$(document).ready(function(){
	
	function showLoading(){
		$("#loading-spinner").show();
		$("#page-content").hide();
	}
	
	function loadingFinish(){
		$("#loading-spinner").hide();
		$("#page-content").show();
	}
	
	// Example GET method implementation:
	async function callUrl(url = '', method, payload = {}) {
	  // Default options are marked with *
	  const response = await fetch(url, {
	    method: method, // *GET, POST, PUT, DELETE, etc.
	    mode: 'cors', // no-cors, *cors, same-origin
	    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
	    credentials: 'same-origin', // include, *same-origin, omit
	    headers: {
	      'Content-Type': 'application/json'
	    },
	    redirect: 'follow', // manual, *follow, error
	    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
	    //body: payload // body data type must match "Content-Type" header
	  });
	  return response.json(); // parses JSON response into native JavaScript objects
	}
	
	async function callNoGetUrl(url = '', method, payload = {}) {
		  // Default options are marked with *
		  const response = await fetch(url, {
		    method: method, // *GET, POST, PUT, DELETE, etc.
		    mode: 'cors', // no-cors, *cors, same-origin
		    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
		    credentials: 'same-origin', // include, *same-origin, omit
		    headers: {
		      'Content-Type': 'application/json'
		    },
		    redirect: 'follow', // manual, *follow, error
		    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
		    body:  JSON.stringify(payload) // body data type must match "Content-Type" header
		  });
		  return response.json(); // parses JSON response into native JavaScript objects
		}
	
	// RG-04 : Callback quand l'url retourne la réponse
	function OnApiGetAllArticle(data){
		// RG-05 Nettoyer la liste
		$('#ListView').empty();
		
		// RG-06 : Pour chaque article json, afficher l'article
		data.forEach(note => {
			// Ajouter un <li> avec le titre de l'article dans le url
			// j'afficher un article dans la liste
			var btnDelete = '<a href="#" onclick="deleteNote('+note.id +')">Delete</a>';
			$('#ListView').append('<div class="uk-card-default uk-card-hover"><p style="padding: 1rem">' + note.details + btnDelete + '<p></div>');
			
		
		});
		
		// RG-07 : Quand j'ai terminé le chargement des articles
		loadingFinish();
	}
	 
	  function deleteNote(id){
		// RG-03: Appeler l'URL (en GET)
		callUrl('http://localhost:8080/SuiviRepas/api/rest/note/delete/' + id, "GET", {})
		  .then((data) => { 
			// RG-04
		
		 }); 
	  }
	  
	 function refreshAllNote(){
		// RG-02: Afficher le chargement
		showLoading();
		
		// RG-03: Appeler l'URL (en GET)
		callUrl('http://localhost:8080/SuiviRepas/api/rest/note/all', "GET", {})
		  .then((data) => { 
			// RG-04
			OnApiGetAllArticle(data)
		 });
	 }
	  
	// Quand j'appuye sur le boutton BtnWebservice
	$( "#BtnWebservice" ).on( "click", () => {
		
		var form = $('#form-note')[0];
		
		// FormData object 
		var formData = new FormData(form);
		var jsonNote = { details: formData.get("details") };

		
		// Appeler l'URL (en GET)
		callNoGetUrl('http://localhost:8080/SuiviRepas/api/rest/note/add', "POST", jsonNote)
		  .then((data) => { 
			// 
			alert(data)
		 });
	});

	refreshAllNote();
}); 


</script>    
<jsp:include page="/views/template/page-end.jsp"></jsp:include>