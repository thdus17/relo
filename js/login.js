$(() => {
  //디바운스
  let timer = false; //최초 false
  const filterByDebounce = (e, callback) => {
    if (timer) {
      clearTimeout(timer);
    }
    timer = setTimeout(function () {
      callback('' + e.target.value);
    }, 200); //200ms 이후 반응(디바운스)
  };

  //비밀번호 정규식 검사
  function validatePassword(strPassword) {
    const reg_password =
      /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    if (!reg_password.test('' + strPassword)) {
      return false;
    }
    return true;
  }

  // -- 아이디&비밀번호 빈 칸 체크 및 비밀번호 유효성 검사 start --

  $('input').on('input', function () {
    let valid_pwd = check_valid_pwd();
    let $id = $('#id').val();
    let $pwd = $('#pwd').val();

    console.log(valid_pwd);

    if ($id == '' || $pwd == '') {
      $('#login').attr('disabled', true);
      $('#login').css('background-color', '');
      $('#login').css('color', '');
      $('#login').css('cursor', '');
    } else if (valid_pwd) {
      $('#login').attr('disabled', false);
      $('#login').css('background-color', '#000000');
      $('#login').css('color', '#fff');
      $('#login').css('cursor', 'pointer');
    }
  });

  let flag = false;
  function check_valid_pwd() {
    $('#pwd').on('input', function (e) {
      filterByDebounce(e, (strPassword) => {
        let error_msg = '';
        if (!validatePassword(strPassword)) {
          error_msg = '영문, 숫자, 특수문자를 조합해서 입력해주세요. (8-16자)';
          $('#login').attr('disabled', true);
          flag = false;
          $('#title_pwd').css('color', 'tomato');
          $('#pwd').css('border-bottom', '1px solid tomato');
          $('#error_msg_pwd').css('color', 'tomato');
          $('#login').css('background-color', '');
          $('#login').css('color', '');
          $('#login').css('cursor', '');
        } else {
          $('#title_pwd').css('color', '');
          $('#pwd').css('border-bottom', '');
          flag = true;
        }
        $('#error_msg_pwd').html(error_msg);
      });
    });
    return flag;
  }

  // -- 아이디&비밀번호 빈 칸 체크 및 비밀번호 유효성 검사 end --

  // -- 로그인 start --

  $('#login').on('click', function () {
    let url = backUrl + 'member/login.do';

    let $id = $('#id').val();
    let $pwd = $('#pwd').val();

    $.ajax({
      url: url,
      xhrFields: {
        withCredentials: true,
      },
      method: 'post',
      data: {
        id: $id,
        pwd: $pwd,
      },
      success: function (jsonObj) {
        console.log(jsonObj);
        if (jsonObj != null) {
          alert(jsonObj);
        } else {
          location.href = frontUrl + 'index.html';
        }
      },
      error: function (xhr) {
        alert('오류' + xhr.status);
      },
    });
  });
  // -- 로그인 end --
});
