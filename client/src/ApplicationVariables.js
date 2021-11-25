export const ApplicationRoutes = {
    Home_Route: '/',
    Login_Route: '/ui/login',
    Register_Route: '/ui/register',
    Balances_Route: '/ui/balances',
    Profile_Route: '/ui/profile',
    Verify_Add_New_Source:'/ui/complete_add_source',
    Logout:'/ui/logout'
};

export const BALANCES_URL = 'http://localhost:8083/portfolio/balances';
export const LOGIN_URL = 'http://localhost:8084/user/login';
export const REGISTER_URL = 'http://localhost:8084/user/register';
export const NORDIGEN_COUNTRIES_URL = 'http://localhost:8087/source_manager/nordigen_countries';
export const NORDIGEN_CREATE_REQUISITION_URL = 'http://localhost:8087/source_manager/create_requisition';
export const BANKS_URL = 'http://localhost:8087/source_manager/banks';
export const PROVIDER_API_KEYS='http://localhost:8084/user/account/provider_api_keys';
export const VERIFY_REQUSITION = 'http://localhost:8087/source_manager/verify_requisition';
