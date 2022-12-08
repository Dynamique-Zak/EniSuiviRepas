<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add Meal</h1>


 <!-- Formulaire -->
  <form method="post" action="/SuiviRepas/add-meal-simple">
      <!-- Champ Date  -->
      <input type="text" name="date" placeholder="Date" value="" />
      
      <!-- Champ Heure -->
      <input type="text" name="hour" placeholder="Heure" value="" />
  
      <!-- Bouton de validation  -->
      <input type="submit" value="Enregistrer" />
  </form>


</body>
</html>