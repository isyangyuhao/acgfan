//配置前端路由
	app.config(["$routeProvider", function($routeProvider) {
				$routeProvider
					.when("/", {
						controller : "baseShowController",
						templateUrl : "template/baseShow.html"
					})
					.when("/baseConfig", {
						controller :"baseConfigController",
						templateUrl : "template/baseConfig.html"
					})
					.when("/userConfig", {
						controller :"userConfigController",
						templateUrl : "template/userConfig.html"
					})
					.when("/indexConfig", {
						controller :"indexConfigController",
						templateUrl : "template/indexConfig.html"
					})
					.when("/videoConfig", {
						controller :"videoConfigController",
						templateUrl : "template/videoConfig.html"
					})
					.when("/commentConfig", {
						controller :"commentConfigController",
						templateUrl : "template/commentConfig.html"
					})
					.when("/danmuConfig", {
						controller :"danmuConfigController",
						templateUrl : "template/danmuConfig.html"
					})
					.when("/shopConfig", {
						controller :"shopConfigController",
						templateUrl : "template/shopConfig.html"
					})
					.when("/gameConfig", {
						controller :"gameConfigController",
						templateUrl : "template/gameConfig.html"
					})
					.when("/paletteConfig", {
						controller :"paletteConfigController",
						templateUrl : "template/paletteConfig.html"
					})
					.when("/superConfig", {
						controller :"superConfigController",
						templateUrl : "template/superConfig.html"
					})
					.otherwise({
						redirectTo : "/"
					});
			}]);