import React from 'react';
import CookieConsent from 'react-cookie-consent';

const CookieConsentPopup = () => {
  return (
    <div>
      <CookieConsent
        location="bottom"
        buttonText="I understand!"
        cookieName="3vial-Cookie-Consent"
        style={{ background: '#FFFFFF', color: '#2E2C34' }}
        buttonStyle={{ background: '#9031DB', borderRadius: '12px', color: '#FFFFFF', fontSize: '16px', padding: '10px 10px', }}
        expires={250} overlay
      >
        This website uses cookies to enhance the user experience.{' '}
      </CookieConsent>
    </div>
  );
};

export default CookieConsentPopup;
