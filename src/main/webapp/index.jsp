<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>REVERSO</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
  <header class="flex items-start place-content-between mb-8 bg-gradient-to-r from-cyan-500">
    <h1 class="text-3xl font-bold m-5">REVERSO</h1>
    <a href="login.jsp" class="text-lg m-5">Login</a>
  </header>
  <main class="grid place-content-center">
    <section class="flex justify-center m-8">
      <h2 class="text-xl font-medium">Que faisons-nous aujourd'hui?</h2>
    </section>
    <article class="grid justify-items-center">
      <div class="grid grid-cols-1">
        <label for="choix-concerne" class="text-xl ml-8">Qui cela concerne?</label>
        <select name="concerne" id="choix-concerne" class="border-2" class="max-w-32">
          <option value="">--Choisissez une classe--</option>
          <option value="client">Client</option>
          <option value="prospect">Prospect</option>
        </select>
      </div>
      <h3 class="text-xl mt-8 ml-8">Que voulez-vous faire?</h3>
      <div class="flex space-x-4 ml-10 mt-5">
        <button class="border-solid border-2 border-sky-400  rounded-lg w-20">Afficher</button>
        <button class="border-solid border-2 border-yellow-400 rounded-lg w-20">Modifier</button>
        <button class="border-solid border-2 border-red-400 rounded-lg w-20">Supprimer</button>
        <button class="border-solid border-2 border-green-400 rounded-lg w-20"><a href="formulaire.jsp">Nouveau</a></button>
      </div>
    </article>
  </main>
</body>
</html>