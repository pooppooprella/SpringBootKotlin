'use strict';

function getAll(selector) {
	return Array.prototype.slice.call(document.querySelectorAll(selector), 0);
}

var $dropdowns = getAll('.dropdown:not(.is-hoverable)');
$(document)
	.on('click', function (e) {
		const className = e.target.className;
		if (!className.includes('modal-background') && !className.includes('modal-close') && !className.includes('delete') && !className.includes('button-modal-close')) {
			if (!$(e.target).closest('.dropdown').length) {
				$('.dropdown.is-active').removeClass('is-active');
			}
		}
	})
	.on('mouseenter focus', '.dropdown-trigger .button', function (e) {
		$('.dropdown').removeClass('is-hover');
		$(this).closest('.dropdown').addClass('is-hover');
	})
	.on('mouseleave', '.dropdown-trigger .button', function (e) {
		$(this).closest('.dropdown').removeClass('is-hover');
	})
	.on('click', '.dropdown-trigger .button', function (e) {
		e.preventDefault();
		$('.dropdown:not(.is-hover)').removeClass('is-active');
		if ($(this).closest('.dropdown').hasClass('is-active')) {
			$(this).closest('.dropdown').removeClass('is-active');
		} else {
			$(this).closest('.dropdown').addClass('is-active');
		}
	})
	.on('click', '.dropdown-item', function (e) {
		if (!$(this).closest('.header-user-dropdown').length) {
			if ($(this).hasClass('is-icon')) {
				$(this).addClass('is-active').siblings().removeClass('is-active');
				$(this).closest('.dropdown').find('[aria-controls="dropdown-menu"]').children('span').eq(0).empty().append($(this).children().clone());
				$(this).closest('.dropdown').find('[aria-controls="dropdown-menu"]').children('span').eq(0).append($(this).text());
			} else {
				$(this).addClass('is-active').siblings().removeClass('is-active');
				$(this).closest('.dropdown').find('[aria-controls="dropdown-menu"]').children('span').eq(0).text($(this).text());
			}
			var dropdownWidth = $(this).outerWidth();
			if ($('.header-search__dropdown').length) {
				$(this).closest('.header-search__dropdown').css('min-width', dropdownWidth).find('.dropdown').css('width', 'auto');
			}
			$('.dropdown.is-active').removeClass('is-active');
		}
	});

function closeDropdowns() {
	$dropdowns.forEach(function ($el) {
		$el.classList.remove('is-active');
	});
}

$(document).on('click', '.modal-button', function (e) {
	e.preventDefault();
	var target = '#' + $(this).data('target');
	$('html').addClass('is-clipped');
	$(target).addClass('is-active').attr('tabindex', 0).focus();
});

// Modal Close
$(document).on('click', '.modal-background, .modal-close, .modal-card-head .delete, .modal .button-modal-close', function (e) {
	closeModals();
});
// modal 상태에서 띄워져 있는 modal 닫기
$(document).on('click', '.modal-background-this, .modal-close-this', function (e) {
	$(this).closest('.modal').removeClass('is-active');
});

function closeModals() {
	$('html').removeClass('is-clipped');
	$(document).find('.modal').removeClass('is-active');
}

$(function () {
	setTimeout(function () {
		$('.lnb-menulist li').each(function () {
			if ($(this).children('ul').length) {
				$(this).prepend('<em></em>');
			}
		});
	}, 100);
	$('body').on('click', '.lnb-menulist-item > em', function (e) {
		$('.lnb-menulist-item').find('li').removeClass('is-active');
	});
	$('body').on('click', '.lnb-menulist em', function (e) {
		if ($(this).parent().hasClass('is-active')) {
			$(this).parent().removeClass('is-active');
		} else {
			$(this).parent().addClass('is-active').siblings().removeClass('is-active');
		}
	});
});

// datepicker
$(function () {
	if ($('.datepicker-wrap .datepicker').length > 0) {
		$.datepicker.setDefaults({
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			dateFormat: 'yy.mm.dd',
			showMonthAfterYear: true,
			yearSuffix: '년',
			buttonImageOnly: true,
			buttonImage: '/resources/images/ico-calendar.png',
			buttonText: 'Select date',
		});
		$.each($('.datepicker-wrap .datepicker'), function () {
			var $this = $(this);

			if ($(this).data('year') == 'button') {
				$this.datepicker({
					beforeShow: function () {
						setTimeout(function () {
							drawChangeYear($this);
						}, 0);
					},
					onChangeMonthYear: function (y, m, ins) {
						setTimeout(function () {
							drawChangeYear($this);
						}, 0);
					},
				});
			} else {
				$this.datepicker();
			}
		});
	}

	function drawChangeYear(datebox) {
		var prevStr = '<a class="ui-datepicker-prev ui-corner-all ws-year" id="wsPrevYear" style="left: 0px">이전 년</a>';
		var nextStr = '<a class="ui-datepicker-next ui-corner-all ws-year" id="wsNextYear" style="right: 0px;">다음 년</a>';
		$('.ui-datepicker-header').prepend(prevStr);
		$('.ui-datepicker-header').prepend(nextStr);

		$('#wsPrevYear').on('click', function (e) {
			e.preventDefault();
			$.datepicker._adjustDate($(datebox), -1, 'Y');
		});
		$('#wsNextYear').on('click', function (e) {
			e.preventDefault();
			$.datepicker._adjustDate($(datebox), 1, 'Y');
		});
	}
});

// 파일업로드
$(function () {
	var $file = $('#file-input'),
		$label = $file.next('label'),
		$labelText = $label.find('span'),
		$labelRemove = $('i.remove'),
		labelDefault = $labelText.text();

	$labelRemove.hide();

	// File change
	$file.on('change', function (event) {
		var fileName = $file.val().split('\\').pop();
		if (fileName) {
			console.log($file);
			$labelText.text(fileName);
			$labelRemove.show();
		} else {
			$labelText.text(labelDefault);
			$labelRemove.hide();
		}
	});

	// Remove file
	$labelRemove.on('click', function (event) {
		$file.val('');
		$labelText.text(labelDefault);
		$labelRemove.hide();
		console.log($file);
	});
});

function makeTelFormat(object){
    //숫자만 입력받도록 처리
    object.value = object.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');

    //전화번호 형태로 변환
    object.value = object.value
    .replace(/[^0-9]/g, '')
    .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
}