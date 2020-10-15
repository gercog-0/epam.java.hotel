<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15.10.2020
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/media.css">
    <title>Home</title>
</head>

<body>
<div class="layout">
    <div class="layout-header">
        <div class="container">
            <div class="layout-header__row">
                <a href="#" class="logo">
                    <div class="logo__subtitle">The greatest and most reputable</div>
                    Deluxe Hotel
                </a>
                <div class="layout-header__menu">
                    <ul class="navigation">
                        <li class="navigation__item">
                            <a href="#" class="navigation__link">Sign In</a>
                        </li>
                        <li class="navigation__item">
                            <a href="#" class="navigation__link">Sign Up</a>
                        </li>
                        <li class="navigation__item">
                            <a href="#" class="navigation__link">Account</a>
                        </li>
                        <li class="navigation__item">
                            <a href="#" class="navigation__link">Log Out</a>
                        </li>
                    </ul>
                    <div class="language-select">
                        <div class="language-select__current">
                            <span class="language-select__label">RU</span>
                            <span class="language-select__arrow"></span>
                        </div>
                        <div class="language-select__dropdown">
                            <ul class="menu">
                                <li>
                                    <a href="lang=ru"><span>Russian</span></a>
                                </li>
                                <li>
                                    <a href="lang=ru"> <span>English</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="layout-body"
         style="background-image: url(img/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <h2 class="admin-section__title">Users</h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th>Login</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Is banned </th>
                            <th>Is activated </th>
                            <th class="default-table__sort">
                                <span>Sort by:</span>
                                <a href="#">Name</a>
                                <a href="#">Login</a>
                            </th>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>+123123123</td>
                            <td>kirill</td>
                            <td>losk</td>
                            <td>free</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Ban</a>
                                <a href="#" class="default-table__button default-table__button--red">Unban</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="layout-footer">
        <div class="container">
            <div class="layout-footer__copyright">Copyright © Deluxe Hotel 2020</div>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/main.js"></script>

</html>