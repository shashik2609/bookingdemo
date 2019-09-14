(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    Bookingscontroller.$inject = ['$http'];
    function BookingsController($http){
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/bookings/all";
            var bookingPromise = $http.get(url);
            bookingPromise.then(function (response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable() {
            var url = "bookings/affordable/" + 100;
            var bookingPromise = $http.get(url);
            bookingPromise.then(function (response) {
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id) {
            var url = "bookings/remove/" + id;
            $http.post(url).then(function (response) {
                vm.bookings = response.data;
            });
        }
    }

})();