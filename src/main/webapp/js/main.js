function toggleLanguageSelect() {
  var selectButton = $('.language-select__current');

  selectButton.on('click', function() {
    var parent = $(this).closest('.language-select');
    parent.toggleClass('open');
    parent.find('.language-select__dropdown').slideToggle();
  });
}

$(document).ready(function() {
  var header = $('.layout-header');
  var offsetHeader = header.height();

  if ($(window).scrollTop() > offsetHeader) {
    header.addClass('layout-header--fixed');
  }

  $(window).on('scroll', function() {
    $('.language-select').removeClass('open');
    $('.language-select__dropdown').slideUp();
    
    if ($(window).scrollTop() > offsetHeader) {
      header.addClass('layout-header--fixed');
    } else {
      header.removeClass("layout-header--fixed");
    }
  });

  toggleLanguageSelect();
});
