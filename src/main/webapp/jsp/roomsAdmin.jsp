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
    <div class="layout-body"
         style="background-image: url(img/texture.png); background-repeat: repeat; background-size: auto; background-attachment: fixed;">
        <div class="admin-section">
            <div class="container">
                <div class="add-rooms-form">
                    <h3 class="add-rooms-form__title">Add room</h3>
                    <form action="" class="form">
                        <div class="form-grid">
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label">Number</span>
                                    <input type="text" class="form-control" placeholder="Input number of room">
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label">Comfort Type</span>
                                    <select class="form-control" required name="comfort">
                                        <option value="" selected hidden>Select room type</option>
                                        <option value="standart">standart</option>
                                        <option value="economy">economy</option>
                                        <option value="luxury">luxury</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label">Places</span>
                                    <select class="form-control" required name="places">
                                        <option value="" selected hidden>Select count places</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-group">
                                    <span class="form-label">Price</span>
                                    <input type="text" class="form-control" placeholder="Input price of room">
                                </div>
                            </div>
                            <div class="form__item">
                                <div class="form-btn">
                                    <button type="submit" class="submit-btn">Add room</button>
                                </div>
                            </div>
                        </div>
                        <!-- ошибка валидации -->
                        <div class="form-error">
                            <p>Something was wrong!!!!</p>
                        </div>
                    </form>
                </div>
                <h2 class="admin-section__title">Rooms</h2>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <tr>
                            <th>Number</th>
                            <th>Type</th>
                            <th>Places</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th class="default-table__sort">
                                <span>Sort by:</span>
                                <a href="#">Status</a>
                            </th>
                        </tr>
                        <tr>
                            <td>losk</td>
                            <td>comfort</td>
                            <td>3</td>
                            <td>500$</td>
                            <td>free</td>
                            <td class="default-table__action">
                                <a href="#" class="default-table__button default-table__button--green">Active</a>
                                <a href="#" class="default-table__button default-table__button--red">Not active</a>
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