<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15.10.2020
  Time: 13:58
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
    <div class="layout-body" style="background-image: url(img/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <h2 class="admin-section__title">Active booking</h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th>Username</th>
                            <th>Room number</th>
                            <th>Arrival Date</th>
                            <th>Departure Date</th>
                            <th>Status</th>
                            <th class="default-table__sort">
                                <span>Sort by:</span>
                                <a href="#">Arrival Date</a>
                            </th>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
                            </td>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>512</td>
                            <td>14.10.2020</td>
                            <td>16.10.2020</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Approve</a>
                                <a href="#" class="default-table__button default-table__button--red">Cancel</a>
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