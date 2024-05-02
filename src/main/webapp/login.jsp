<%--
  Created by IntelliJ IDEA.
  User: CDA02
  Date: 15/04/2024
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authentification</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <header class="flex items-start place-content-between mb-8 bg-gradient-to-r from-cyan-500">
        <h1 class="text-3xl font-bold m-5">REVERSO</h1>
    </header>
    <main class="grid place-content-center">
        <section class="flex justify-center m-5">
            <h2 class="text-xl font-medium">Qui êtes-vous?</h2>
        </section>
        <article class="flex justify-center">
            <form id="loginForm" action="<%=request.getContextPath()%>/connect" method="post">
                <ul class="flex flex-col space-y-4">
                    <li class="grid grid-cols-1">
                        <label for="email">Identifiant ou Email:</label>
                        <input type="text" id="email" name="email" class="border-solid border-2 rounded-lg px-2"/>
                    </li>
                    <li class="grid grid-cols-1">
                        <label for="password">Mot de passe:</label>
                        <input type="password" id="password" name="password" minlength="8" class="border-solid border-2 rounded-lg px-2">
                    </li>
                </ul>
                <div>
                    <input type="checkbox" id="show-pass" name="show-password"/>
                    <label for="show-pass">Afficher le mot de passe</label>
                </div>
                <div class="m-8 text-blue-600 underline">
                    <a href="pass-forgotten">Mot de passe oublié</a>
                </div>
                <div>
                    <button type="submit" class="border-solid border-2 border-sky-400  rounded-lg w-32">Connection</button>
                    <button class="border-solid border-2 border-sky-400  rounded-lg w-20"><a href="index.jsp">Retour</a></button>
                </div>
            </form>
        </article>
    </main>
</body>
</html>