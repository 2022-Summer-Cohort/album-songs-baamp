export default function header(){
    return `
    <header>
    <img class="logo" src="/src/js/images/SODASHOPLOGO.png" alt=""></a>
    <div class="nav">
        <ul class="menu">
            <li class="menu-item">
                <a data-modal-target="modal" class="sub-btn" href="#">Miscelanious link <i></i> </a>
                <ul class="info-modal-link">
                    <li class="modal">
                        <div class="modal-header">
                            popup window
                            <button class="close-modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Culpa commodi minima facere in
                            voluptates dolorum doloremque sequi impedit. Atque quo delectus non mollitia sed minus
                            perferendis tempora suscipit maxime voluptatem?
                        </div>
                    </li>
                    <div class="active" id="overlay"></div>
                </ul>
            </li>
            <div id="overlay"></div>

            <li class="menu-item">
                <a class="sub-btn">Developers<i class="fas fa-angle-down"></i>
                    <ul class="sub-menu">
                        <li class="menu-item">About the Developers
                </a>
            </li>
            <div class="space-items">
                <li class="sub-item"><a href="#">Item</a>
                    <a href="#">
                        <img class="dropdown-images" src="#" alt="#">
                    </a>
                </li>
            </div>
            <div class="space-items">
                <li class="sub-item"><a href="#">Item</a>
                    <a href="#">
                        <img class="dropdown-images" src="#" alt="#">
                    </a>
                </li>
            </div>
            <div class="space-items">
                <li class="sub-item"><a href="#">Item</a>
                    <a href="#">
                        <img class="dropdown-images" src="#" alt="#">
                    </a>
                </li>
            </div>
        </ul>
        </li>
        <li class="menu-item"><a href="#">Miscelanious Link</a></li>
        </ul>
    </div>
</header>`
}