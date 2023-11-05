<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
            <section id="container">
                <div class="sidebar">
                    <img
                        src="<%=request.getContextPath() %>/images/pokemon.PNG"
                        alt="pokemon logo"
                        width='250'
                        height='100'
                    />
                    <nav class="nav">
                        <li class="nav-item">
                            <button class="btn btn-sidebar btn-header" id="all">
                                all
                            </button>
                        </li>
                        <ul class="nav-list">
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header normal"
                                    id="normal"
                                >
                                    normal
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header fire"
                                    id="fire"
                                >
                                    fire
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header water"
                                    id="water"
                                >
                                    water
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header grass"
                                    id="grass"
                                >
                                    grass
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header electric"
                                    id="electric"
                                >
                                    electric
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header ice"
                                    id="ice"
                                >
                                    ice
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header fighting"
                                    id="fighting"
                                >
                                    Fighting
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header poison"
                                    id="poison"
                                >
                                    poison
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header ground"
                                    id="ground"
                                >
                                    ground
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header flying"
                                    id="flying"
                                >
                                    flying
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header psychic"
                                    id="psychic"
                                >
                                    Psychic
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header bug"
                                    id="bug"
                                >
                                    Bug
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header rock"
                                    id="rock"
                                >
                                    rock
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header ghost"
                                    id="ghost"
                                >
                                    ghost
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header dark"
                                    id="dark"
                                >
                                    dark
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header dragon"
                                    id="dragon"
                                >
                                    dragon
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header steel"
                                    id="steel"
                                >
                                    steel
                                </button>
                            </li>
                            <li class="nav-item">
                                <button
                                    class="btn btn-sidebar btn-header fairy"
                                    id="fairy"
                                >
                                    fairy
                                </button>
                            </li>
                        </ul>
                    </nav>
                </div>
                <main>
                    <div>
                        <div class="pokemon-all" id="readyPokemon">
                        </div>
                    </div>
                </main>
            </section>
            <script src="<%=request.getContextPath() %>/js/index.js"></script>
<%@ include file="/views/common/footer.jsp" %>