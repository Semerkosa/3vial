import Nav from './Nav';

import logo from '../assets/header/trivial-logo.svg';
import line from '../assets/header/line.svg';
import horizontalArrow from '../assets/header/arrow-swap-horizontal.svg';
import notification from '../assets/header/notification.svg';
import messages from '../assets/header/messages.svg'
import messagesDot from '../assets/header/messages-dot.svg'
import services from '../assets/header/services.svg';
import avatar from '../assets/header/avatar.png';
import arrowDropDown from '../assets/header/arrow-drop-down.svg';

const Header = () => {
    let userFirstName = 'Eric';

    function hasMessages() {
        if (true) {
            return (<a className='c-header__messages-dot' href='/'>
                <img src={messagesDot} />
            </a>)
        } else {
            return (<a className='c-header__messages' href='/'>
                <img src={messages} />
            </a>)
        }

    };

    return (
        <header className='c-header'>
            <div className='o-page-content-wrapper'>
                <div className='c-header__left-part'>
                    <div className='c-header__logo'>
                        <a href='/'>
                            <img src={logo} />
                        </a>
                    </div>
                    <div className='c-header__line'>
                        <img src={line} />
                    </div>
                    <Nav />
                </div>

                <div className='c-header__right-part'>
                    <div className='c-header__currencies-dropdown'>
                        {/* Replace with CurrencyDropDown component */}
                        <button>
                            <span className='c-header__currency'>USD</span>
                            <img src={horizontalArrow} />
                        </button>
                    </div>
                    
                    <div className='c-header__user-services'>
                        <a className='c-header__notification' href='/'>
                            <img src={notification} />
                        </a>
                        {hasMessages()}
                        <a className='c-header__services' href='/'>
                            <img src={services} />
                        </a>
                    </div>

                    <div className='c-header__user-profile'>
                        <div className='c-header__user-avatar'>
                            <img src={avatar} />
                        </div>
                        <div className='c-header__user-profile-dropdown'>
                            <button>
                                <span className='c-header__user-first-name'>{userFirstName}</span>
                                <img src={arrowDropDown} />
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </header>
    )
}

export default Header;
