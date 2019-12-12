angular.module('exercise', [])
    .run(function($rootScope, $http) {

        $rootScope.getTournaments = function() {
            $http.get('/tournament', {
                params: {
                    operation: 'getTournaments'
                }
            
            }).then(function(result) {
                $rootScope.tournaments = result.data;
                angular.forEach($rootScope.tournaments, function(tournament) {
                    $rootScope.getPlayersInTournament(tournament.id);
                });
            });
        };

        $rootScope.addTournament = function(rewardAmount) {
        	if (rewardAmount != undefined && rewardAmount.match("^[0-9]+$") != null) {
                $http.get('/tournament', {
                    params: {
                        operation: 'addTournament',
                        reward_amount: rewardAmount
                    }
                
                }).then(function(result) {
                    $rootScope.rewardAmount = undefined;
                    $rootScope.getTournaments();
                });
        	}
        };

        $rootScope.editTournament = function(tournament) {
            $rootScope.editTournamentId = tournament.id;
            $rootScope.editRewardAmount = tournament.reward_amount;
        };

        $rootScope.updateTournament = function(tournamentId, rewardAmount) {
        	if (rewardAmount != undefined && rewardAmount.match("^[0-9]+$") != null) {
                $http.get('/tournament', {
                    params: {
                        operation: 'updateTournament',
                        id: tournamentId,
                        reward_amount: rewardAmount
                    }
                
                }).then(function(result) {
                    $rootScope.editTournamentId = undefined;
                    $rootScope.editRewardAmount = undefined;
                    $rootScope.getTournaments();
                });
        	}
        };

        $rootScope.removeTournament = function(tournamentId) {
            $http.get('/tournament', {
                params: {
                    operation: 'removeTournament',
                    id: tournamentId
                }
            
            }).then(function(result) {
                $rootScope.getTournaments();
            });
        };
        
        $rootScope.prepareAddPlayer = function(tournament) {
        	$rootScope.playerTournamentId = tournament.id;
        };

        $rootScope.addPlayerIntoTournament = function(tournamentId, playerName) {
        	if (playerName != undefined) {
	            $http.get('/player', {
	                params: {
	                    operation: 'addPlayerIntoTournament',
	                    tournament_id: tournamentId,
	                    name: playerName
	                }
	            
	            }).then(function(result) {
	                $rootScope.playerTournamentId = undefined;
	                $rootScope.playerName = undefined;
	                $rootScope.getPlayersInTournament(tournamentId);
	            });
        	}
        };

        $rootScope.removePlayerFromTournament = function(tournamentId, playerId) {
            $http.get('/player', {
                params: {
                    operation: 'removePlayerFromTournament',
                    tournament_id: tournamentId,
                    id: playerId
                }
            
            }).then(function(result) {
                $rootScope.getPlayersInTournament(tournamentId);
            });
        };

        $rootScope.getPlayersInTournament = function(tournamentId) {
            $http.get('/player', {
                params: {
                    operation: 'getPlayersInTournament',
                    tournament_id: tournamentId
                }
            
            }).then(function(result) {
            	var i = 0;
            	for (i; i < $rootScope.tournaments.length; i++) {
            		if ($rootScope.tournaments[i].id == tournamentId) {
            			break;
            		}
            	}
                $rootScope.tournaments[i].players = result.data;
            });
        };

        $rootScope.getTournaments();
    });