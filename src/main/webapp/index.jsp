<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet index" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body>
    <header class="header">
        <div>Баранов Вячеслав P32301, Вариант #321176</div>
    </header>
    <table class="main-table">
    <tr class="graphic">
        <td style="vertical-align: top;">
            <img src="<%=request.getContextPath()%>/img/areas.png" width="420" height="380" alt="Graph"/>
        </td>
        <td style="vertical-align: top;">

            <div id="coordinates-form">
                <fieldset>
                    <table>
                        <tr>
                            <td class="first-letter">
                                X:
                            </td>
                            <td>
                                <div class="x-checks">
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="-4">
                                        <span>-4</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="-3">
                                        <span>-3</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="-2">
                                        <span>-2</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="-1">
                                        <span>-1</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="0" checked>
                                        <span>0</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="1">
                                        <span>1</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="2">
                                        <span>2</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="3">
                                        <span>3</span>
                                    </label>
                                    <label>
                                        <input class="x-check" type="checkbox" name="x" value="4">
                                        <span>4</span>
                                    </label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="first-letter">
                                Y:
                            </td>
                            <td>
                                <div class="y-text" id="Y" align="left">
                                    <label>
                                        <input id="y-textinput" type="text" name="y" placeholder="[-3; 5]"
                                        />
                                    </label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="first-letter">
                                <div class="first-letter">R:</div>
                            </td>
                            <td align="center">
                                <div class="R-text" id="R">
                                    <label>
                                        <ul class="r-radio">
                                            <li>
                                                <input type="radio" id="a1" name="r" value="1" class="r-radio-check"/>
                                                <label for="a1">1</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="a2" name="r" value="2" class="r-radio-check"/>
                                                <label for="a2">2</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="a3" name="r" value="3" class="r-radio-check"/>
                                                <label for="a3">3</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="a4" name="r" value="4" class="r-radio-check"/>
                                                <label for="a4">4</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="a5" name="r" value="5" class="r-radio-check"/>
                                                <label for="a5">5</label>
                                            </li>
                                        </ul>
                                    </label>
                                </div>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <button id="submit">Отправить</button>
                <button id="clear-button">Очистить таблицу</button>
            </div>
        </td>
        <td style="vertical-align: top;">
            <table id="check" class="table-container">
                <thead>
                <tr>
                    <th colspan="4" class="bordered">Результаты попаданий</th>
                </tr>
                <tr>
                    <td>Координаты</td>
                    <td>Время</td>
                    <td>Исполнение</td>
                    <td>Результат</td>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </td>
    </tr>
</table>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js" defer type="module"></script>
</body>
</html>
