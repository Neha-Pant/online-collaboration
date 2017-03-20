window.routes =
    {
        "/home":
        {
            templateUrl: 'app/components/basic/home.html',
            controller: 'BasicController',
            controllerAs: 'basicCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        },
        "/about":
        {
            templateUrl: 'app/components/basic/about.html',
            controller: 'BasicController',
            controllerAs: 'basicCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        },
        "/register":
        {
            templateUrl: 'app/components/register/register.html',
            controller: 'RegisterController',
            controllerAs: 'regCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
        "/users":
        {
            templateUrl: 'app/components/register/users.html',
            controller: 'RegisterController',
            controllerAs: 'regCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
        "/login":
        {
            templateUrl: 'app/components/authentication/login.html',
            controller: 'AuthenticationController',
            controllerAs: 'authCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        }
    };

//specify the the backend url from where you are going to get the values
app.constant('REST_URI', 'http://localhost:9090/socialnetworking');



app.config(['$routeProvider', function ($routeProvider) {
    for (var path in window.routes) {
        $routeProvider.when(path, window.routes[path]);
    }
    $routeProvider.otherwise({ redirectTo: '/home' });
}]);