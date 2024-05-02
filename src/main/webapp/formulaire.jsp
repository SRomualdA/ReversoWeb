<%--
  Created by IntelliJ IDEA.
  User: CDA02
  Date: 16/04/2024
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire client</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="style-formulaire.css">
</head>
<body>
<header class="flex items-start place-content-between mb-8 bg-gradient-to-r from-cyan-500">
    <h1 class="text-3xl font-bold m-5">REVERSO</h1>
</header>
<main class="grid place-content-center">
    <section class="m-8">
        <h2 class="text-2xl font-medium">Formulaire client</h2>
    </section>
    <article class="flex justify-center grid grid-cols-1">
        <form id="formulaire" action="FormulaireServlet" method="post">
            <ul class="flex flex-col space-y-4">
                <li class="grid grid-cols-1">
                    <label for="raisonS" class="grid place-self-center">Raison social</label>
                    <input type="text" id="raisonS" name="raison_social" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="numRue" class="grid place-self-center">Numéro de rue</label>
                    <input type="text" id="numRue" name="num_rue" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="nomRue" class="grid place-self-center">Nom de rue</label>
                    <input type="text" id="nomRue" name="nom_rue" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="cp" class="grid place-self-center">Code postale</label>
                    <input type="text" id="cp" name="code_postale" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="ville" class="grid place-self-center">Ville</label>
                    <input type="text" id="ville" name="ville" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="numTel" class="grid place-self-center">Numéro de téléphone</label>
                    <input type="tel" id="numTel" name="num_tel" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="email" class="grid place-self-center">Adresse Email</label>
                    <input type="email" id="email" name="email" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="nbeEmpl" class="grid place-self-center">Nombre d'employés</label>
                    <input type="number" id="nbeEmpl" name="nbe_employes" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="chiffre" class="grid place-self-center">Chiffre d'affire</label>
                    <input type="number" id="chiffre" name="chiffre" class="border-solid border-2 rounded-lg px-2"/>
                </li>
                <li class="grid grid-cols-1">
                    <label for="commentaire" class="grid place-self-center">Commentaire</label>
                    <input type="text" id="commentaire" name="commentaire" class="border-solid border-2 rounded-lg px-2 custom-input-width"/>
                </li>
            </ul>
            <div class="flex justify-between mt-8">
                <button class="border-solid border-2 border-sky-400 rounded-lg w-32">Soumettre</button>
                <button class="border-solid border-2 border-sky-400 rounded-lg w-20"><a href="index.jsp">Retour</a></button>
            </div>
        </form>
    </article>
</main>
</body>
</html>