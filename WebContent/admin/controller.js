//导航栏控制器
app.controller("navController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//获取管理员信息
	$http({
		method : "get",
		url : "admin-admin-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.adminId = data.id;
		$scope.adminName = data.name;
		$scope.adminWork = data.work;
		$scope.adminRole = data.role;
	});
}])
//基本配置控制器
app.controller("baseConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//通过服务器加载视频分类信息
	$http({
		method : "get",
		url : "admin-videoType-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.types = data;
	})
	//视频分类按钮点击事件,获取绑定的修改数据信息
	$scope.alterType = function(id, name, introduce) {
		$scope.alterTypeId = id;
		$scope.alterTypeName = name;
		$scope.alterTypeIntroduce = introduce;
	}
	//视频分类修改数据提交
	$scope.alterTypeSubmit = function() {
		$http({
			method : "get",
			url : "admin-updateVideoType-ajax",
			params : {
				videoTypeId : $scope.alterTypeId,
				videoTypeName : $scope.alterTypeName,
				videoTypeIntroduce : $scope.alterTypeIntroduce,
				time : new Date()
			}
		}).success(function(data) {
			if (data == 1) {
				$http({
					method : "get",
					url : "admin-videoType-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.types = data;
				})
			}
			if (data == 0) {
				$window.alert("修改失败!");
			}
		})
	}
	//获取全部的友情链接
	$http({
		method : "get",
		url : "admin-friendLinks-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.friendLinkData = data;
	})
	//修改友情链接按钮点击事件,获取绑定的修改数据信息
	$scope.alterLink = function(id, name, src) {
		$scope.alterFriendId = id;
		$scope.alterFriendName = name;
		$scope.alterFriendSrc = src;
	}
	//修改友情连接提交
	$scope.alterLinkSubmit = function() {
		$http({
			method : "get",
			url : "admin-updateFriendLink-ajax",
			params : {
				id : $scope.alterFriendId,
				name : $scope.alterFriendName,
				src : $scope.alterFriendSrc
			}
		}).success(function(data) {
			if (data == 1) {
				$http({
					method : "get",
					url : "admin-friendLinks-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.friendLinkData = data;
				})
			}
			if (data == 0) {
				$window.alert("修改失败!");
			}
		})
	}
}])
//用户信息相关管理控制器
app.controller("userConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//获取全部用户信息
	$http({
		method : "get",
		url : "admin-users-ajax",
		params : null
	}).success(function(data) {
		$scope.users = data;
	})
}])
//视频相关管理控制器
app.controller("videoConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载所有视频
	$http({
		method : "get",
		url : "video-videos-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.videoData = data;
	})
	//添加视频
	$scope.addVideoSubmit = function() {
		$http({
			method : "get",
			url : "video-addVideo-ajax",
			params : {
				name : $scope.addVideoName,
				src : $scope.addVideoSrc,
				avSrc : $scope.addVideoAvSrc,
				videoType : $scope.addVideoTypeId
			}
		}).success(function(data) {
			if (data == 1) {
				//加载所有视频
				$http({
					method : "get",
					url : "video-videos-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.videoData = data;
				})
				$scope.addVideoName = "";
				$scope.addVideoSrc = "";
				$scope.addVideoAvSrc = "";
				$scope.addVideoTypeId = "";
			}
			if (data == 0) {
				$window.alert("添加视频失败!");
			}
		})
	}
	//删除视频
	$scope.deleteVideoBtn = function(videoId) {
		$http({
			method : "get",
			url : "video-deleteVideo-ajax",
			params : {id : videoId}
		}).success(function(data) {
			if (data == 1) {
				//加载所有视频
				$http({
					method : "get",
					url : "video-videos-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.videoData = data;
				})
			}
			if (data == 0) {
				$window.alert("删除视频失败!");
			}
		})
	}
	//修改视频按钮
	$scope.alterVideoBtn = function(id, name, src, avSrc) {
		$scope.alterVideoId = id;
		$scope.alterVideoName = name;
		$scope.alterVideoSrc = src;
		$scope.alterVideoAvSrc = avSrc;
	}
	//修改视频提交
	$scope.alterVideoSubmit = function() {
		$http({
			method : "get",
			url : "video-updateVideo-ajax",
			params : {
				id : $scope.alterVideoId,
				name : $scope.alterVideoName,
				src : $scope.alterVideoSrc,
				avSrc : $scope.alterVideoAvSrc
			}
		}).success(function(data) {
			if (data == 1) {
				//加载所有视频
				$http({
					method : "get",
					url : "video-videos-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.videoData = data;
				})
			}
			if (data == 0) {
				$window.alert("修改失败!");
			}
		})
	}
}])
//展示轮播图相关管理控制器
app.controller("indexConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载首页轮播图
	$http({
		method : "get",
		url : "video-indexShow-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.indexData = data;
	})
	//首页轮播图修改按钮
	$scope.indexAlterBtn = function(id, title, src) {
		$scope.alterIndexId = id;
		$scope.alterIndexTitle = title;
		$scope.alterIndexSrc = src;
	}
	//首页轮播图修改提交
	$scope.indexAlterSubmit = function() {
		$http({
			method : "get",
			url : "video-updateIndexShow-ajax",
			params : {
				id : $scope.alterIndexId,
				title : $scope.alterIndexTitle,
				src : $scope.alterIndexSrc
			}
		}).success(function(data) {
			//加载首页轮播图
			$http({
				method : "get",
				url : "video-indexShow-ajax",
				params : {time : new Date()}
			}).success(function(data) {
				$scope.indexData = data;
			})
		})
	}
	//加载视频轮播图
	$http({
		method : "get",
		url : "video-videoShow-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.videoData = data;
	})
	//视频轮播图修改按钮
	$scope.videoAlterBtn = function(id, src, title, videoType) {
		$scope.alterVideoId = id;
		$scope.alterVideoSrc = src;
		$scope.alterVideoTitle = title;
		$scope.alterVideoTypeId = videoType;
	}
	//视频轮播图修改提交
	$scope.videoAlterSubmit = function() {
		$http({
			method : "get",
			url : "video-updateVideoShow-ajax",
			params : {
				id : $scope.alterVideoId,
				title : $scope.alterVideoTitle,
				src : $scope.alterVideoSrc,
				videoType : $scope.alterVideoTypeId
			}
		}).success(function(data) {
			if (data == 1) {
				//加载视频轮播图
				$http({
					method : "get",
					url : "video-videoShow-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.videoData = data;
				})
			}
			if (data == 0) {
				$widow.alert("修改视频轮播图失败!");
			}
		})
	}
}])
//弹幕管理控制器
app.controller("danmuConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载弹幕表
	$http({
		method : "get",
		url : "video-danmu-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.danmuData = data;
	})
	//删除弹幕
	$scope.deleteDanmu = function(danmuId) {
		$http({
			method : "get",
			url : "video-deleteDanmu-ajax",
			params : {id : danmuId}
		}).success(function(data) {
			//加载弹幕表
			$http({
				method : "get",
				url : "video-danmu-ajax",
				params : {time : new Date()}
			}).success(function(data) {
				$scope.danmuData = data;
			})
		})
	}
}])
//视频评论管理器
app.controller("commentConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载视频评论
	$http({
		method : "get",
		url : "video-videoComment-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.commentData = data;
	})
	//删除视频评论
	$scope.deleteComment = function(commentId) {
		$http({
			method : "get",
			url : "video-deleteVideoComment-ajax",
			params : {id : commentId}
		}).success(function(data) {
			//加载视频评论
			$http({
				method : "get",
				url : "video-videoComment-ajax",
				params : {time : new Date()}
			}).success(function(data) {
				$scope.commentData = data;
			})
		})
	}
}])
//周边商城控制器
app.controller("shopConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载商品
	$http({
		method : "get",
		url : "other-goods-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.shopData = data;
	})
	//添加商品
	$scope.addShop = function() {
		$http({
			method : "get",
			url : "other-addGoods-ajax",
			params : {
				name : $scope.addName,
				photoDesc : $scope.addSrc,
				price : $scope.addPrice,
				stock : $scope.addStock
			}
		}).success(function(data) {
			if (data == 1) {
				$http({
					method : "get",
					url : "other-goods-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.shopData = data;
				})
			}
			if (data == 0) {
				$window.alert("添加商品失败!");
			}
		})
	}
	//修改商品按钮
	$scope.alterShopBtn = function(id, name, photoDesc, price, stock) {
		$scope.alterId = id;
		$scope.alterName = name;
		$scope.alterSrc = photoDesc;
		$scope.alterPrice = price;
		$scope.alterStock = stock;
	}
	//修改商品提交
	$scope.alterShopSubmit = function() {
		$http({
			method : "get",
			url : "other-updateGoods-ajax",
			params : {
				id : $scope.alterId,
				name : $scope.alterName,
				photoDesc : $scope.alterSrc,
				price : $scope.alterPrice,
				stock : $scope.alterStock
			}
		}).success(function(data) {
			if (data == 1) {
				//加载商品
				$http({
					method : "get",
					url : "other-goods-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.shopData = data;
				})
			}
			if (data == 0) {
				$window.alert("修改失败!");
			}
		})
	}
	//删除商品
	$scope.deleteShop = function(shopId) {
		$http({
			method : "get",
			url : "other-deleteGoods-ajax",
			params : {id : shopId}
		}).success(function(data) {
			if (data == 1) {
				//加载商品
				$http({
					method : "get",
					url : "other-goods-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.shopData = data;
				})
			}
			if (data == 0) {
				$window.alert("删除商品失败!");
			}
		})
	}
}])
//游戏相关管理控制器
app.controller("gameConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载推荐游戏
	$http({
		method : "get",
		url : "other-game-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.gameData = data;
	})
	//修改推荐游戏按钮
	$scope.alterGameBtn = function(id, name, title, src) {
		$scope.alterGameId = id;
		$scope.alterGameName = name;
		$scope.alterGameTitle = title;
		$scope.alterGameSrc = src;
	}
	//修改推荐游戏提交
	$scope.alterGameSubmit = function() {
		$http({
			method : "get",
			url : "other-updateGame-ajax",
			params : {
				id : $scope.alterGameId,
				name : $scope.alterGameName,
				title : $scope.alterGameTitle,
				src : $scope.alterGameSrc
			}
		}).success(function(data) {
			if (data == 1) {
				//加载推荐游戏
				$http({
					method : "get",
					url : "other-game-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.gameData = data;
				})
			}
			if (data == 0) {
				$window.alert("修改推荐游戏失败!");
			}
		})
	}
	//加载游戏列表
	$http({
		method : "get",
		url : "other-gameIntroduce-ajax",
		params : {time : new Date()}
	}).success(function(data) {
		$scope.listData = data;
	})
	//添加游戏列表
	$scope.addList = function() {
		$http({
			method : "get",
			url : "other-addGameIntroduce-ajax",
			params : {
				name : $scope.addListName,
				typeId : $scope.addListTypeId
			}
		}).success(function(data) {
			if (data == 1) {
				$scope.addListName = "";
				//加载游戏列表
				$http({
					method : "get",
					url : "other-gameIntroduce-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.listData = data;
				})
			}
			if (data == 0) {
				$window.alert("添加游戏失败!");
			}
		})
	}
	//修改游戏列表按钮
	$scope.alterListBtn = function(id, name, typeId) {
		$scope.alterListId = id;
		$scope.alterListName = name;
		$scope.alterListTypeId = typeId;
	}
	//修改游戏列表提交
	$scope.alterListSubmit = function() {
		$http({
			method : "get",
			url : "other-updateGameIntroduce-ajax",
			params : {
				id : $scope.alterListId,
				name : $scope.alterListName,
				typeId : $scope.alterListTypeId
			}
		}).success(function(data) {
			if (data == 1) {
				//加载游戏列表
				$http({
					method : "get",
					url : "other-gameIntroduce-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.listData = data;
				})
			}
			if (data == 0) {
				$window.alert("修改失败");
			}
		})
	}
	//删除游戏列表
	$scope.deleteList = function(listId) {
		$http({
			method : "get",
			url : "other-deleteGameIntroduce-ajax",
			params : {
				id : listId
			}
		}).success(function(data) {
			if (data == 1) {
				//加载游戏列表
				$http({
					method : "get",
					url : "other-gameIntroduce-ajax",
					params : {time : new Date()}
				}).success(function(data) {
					$scope.listData = data;
				})
			}
			if (data == 0) {
				$window.alert("游戏推荐删除失败!");
			}
		})
	}
}])
//画板相关控制器
app.controller("paletteConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	//加载画板
	$http({
		method : "get",
		url : "other-palette-ajax",
		params : {time : new Date()}
		}).success(function(data) {
		$scope.paletteData = data;
	})
	//删除画板
	$scope.deletePalette = function(paletteId) {
		$http({
			method : "get",
			url : "other-deletePalette-ajax",
			params : {
				id : paletteId
			}
			}).success(function(data) {
			if (data == 1) {
				//加载画板
				$http({
					method : "get",
					url : "other-palette-ajax",
					params : {time : new Date()}
					}).success(function(data) {
					$scope.paletteData = data;
				})
			}
			if (data == 0) {
				$window.alert("删除画板失败!");
			}
		})
	}
}])
//管理员控制器
app.controller("superConfigController", ["$scope", "$http", "$window", function($scope, $http, $window) {
	$scope.addAdminRoleId = 3;  //初始化添加管理员角色,默认为视频主站管理员
	//加载管理员
	$http({
		method : "get",
		url : "other-admin-ajax",
		params : {time : new Date()}
		}).success(function(data) {
		$scope.adminData = data;
	})
	//添加管理员
	$scope.addAdmin = function() {
		$http({
			method : "get",
			url : "other-addAdmin-ajax",
			params : {
				name : $scope.addAdminName,
				password : $scope.addAdminPassword,
				roleId : $scope.addAdminRoleId
			}
			}).success(function(data) {
			if (data == 1) {
				$scope.addAdminName = "";
				$scope.addAdminPassword = "";
				$scope.addAdminRoleId = "";
				//加载管理员
				$http({
					method : "get",
					url : "other-admin-ajax",
					params : {time : new Date()}
					}).success(function(data) {
					$scope.adminData = data;
				})
			}
			if (data == 0) {
				$window.alert("添加管理员失败!");
			}
		})
	}
	//删除管理员
	$scope.deleteAdmin = function(adminId) {
		$http({
			method : "get",
			url : "other-deleteAdmin-ajax",
			params : {id : adminId}
			}).success(function(data) {
			if (data == 1) {
				//加载管理员
				$http({
					method : "get",
					url : "other-admin-ajax",
					params : {time : new Date()}
					}).success(function(data) {
					$scope.adminData = data;
				})
			}
			if (data == 0) {
				$window.alert("删除管理员失败!");
			}
		})
	}
	//点击分配任务
	$scope.tellWorkBtn = function(id, work) {
		$scope.workId = id;
		$scope.shouldWork = work;
	}
	//分配任务
	$scope.tellWork = function() {
		$http({
			method : "get",
			url : " other-updateAdminWork-ajax",
			params : {
				id : $scope.workId,
				work : $scope.shouldWork
			}
			}).success(function(data) {
			if (data == 0) {
				$window.alert("分配任务失败!");
			}
		})
	}
}])