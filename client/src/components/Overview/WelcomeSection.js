import { useEffect, useState } from 'react';
import AuthConsumer from '../../authentication';
const WelcomeSection = () => {
    const weekday = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    const month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    let d = new Date();
    const [day, setDay] = useState(weekday[(d).getDay()]);
    const [date, setDate] = useState(() => {
        return (d.getDate().toLocaleString() + ' ' + month[d.getMonth()] + ' ' + d.getFullYear());
    });
    const { getUserInfoFromToken } = AuthConsumer();
    const [username, setUsername] = useState(() => {
        let user = getUserInfoFromToken().sub.split('@')[0];
        return user.charAt(0).toUpperCase() + user.slice(1);
    });

    return (
        <section className='c-welcome-section'>
            <div className='o-page-content-wrapper'>
                {/* Later "Eric" will be replaced with a variable that contains the user's first name. */}
                <div className='greeting'>
                    <h4>Good morning, {username}</h4>
                    <p>Have you added all your investments? <span>Add now</span></p>
                </div>
                <div className='current-date'>
                    <p className='day'>{day}</p>
                    <p className='date'>{date}</p>
                </div>
            </div>
        </section>
    );
};

export default WelcomeSection;
