$(document).ready(function() {
                        setInterval(function() {
                                if ($(window).width() < 1710) {
                                        $("#openCart").removeClass("cart");
                                        $("#openCart").addClass("scart");
                                        }else{
                                                $("#openCart").removeClass("scart");
                                                $("#openCart").addClass("cart");
                                        }}, 1);
                       
                        setInterval(function() {
                                if ($(window).width() < 1710) {
                                        $("#TyhOstSmall").hide();
                                        $("#TyhOst").show();
                                }else{
                                        $("#TyhOst").hide();
                                        $("#TyhOstSmall").show();
                                }}, 1);
                       
                       
                     
                       
                        setInterval(function() {
                                if ($(window).width() < 1710) {
                                       
                                        $("#nappi, #nappi2").removeClass("tnappula");
                                        $("#nappi, #nappi2").addClass("isoNappula");
                                        }else{
                                                $("#nappi, #nappi2").removeClass("isoNappula");
                                                $("#nappi, #nappi2").addClass("tnappula");
                                               
                                        }}, 1);
                               
                        setInterval(function() {
                                if ($(window).width() < 1710) {
                                       
                                        $("#greenKori").show();
                                        }else{
                                                $("#greenKori").hide();
                                               
                                        }}, 1);
                       
                       
                        setInterval(function() {
                                if ($(window).width() > 1710) {
                                        $("#lLogo").hide();
                                       
                                        }else{
                                                $("#lLogo").show();
                                               
                                        }}, 0.00001);
                       
                       
                       
                       
                       
                        $("#greenKori").click(function(){
                        $("#openCart, #TyhOstSmall").slideToggle("slow");
                        });
                       
                       
                        setInterval(function() {
                                if ($("#openCart, #TyhOstSmall").is(":hidden") && $(window).width() > 1710 ) {
                                        location.reload();
                                }}, 999);
                 });// JavaScript Document$