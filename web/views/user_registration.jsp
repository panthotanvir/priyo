<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .has-feedback .form-control-feedback{
            top:0;
        }
        .sky-form{
            border: 1px solid #2ecc71;
        }
        .sky-form header{
            background-color: #2ecc71;
            color: #ffffff;
        }
    </style>
    <script>
        window.onload = function(){
            $('#regexpForm').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    user_name: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            },
                            notEmpty: {
                                message: 'Name is required'
                            }
                        }
                    },
                    email: {
                        validators: {
                            regexp: {
                                regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                message: 'Enter valid email address'
                            },
                            notEmpty: {
                                message: 'Email is required'
                            }
                        }
                    },
                    co_email: {
                        validators: {
                            regexp: {
                                regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                message: 'Enter valid email address'
                            },
                            notEmpty: {
                                message: 'Email is required'
                            },
                            identical: {
                                field: 'email',
                                message: 'The email address must be same'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: 'Password is required'
                            },
                            stringLength: {
                                min: 6,
                                message: 'Password length must be atleast 6 characters'
                            }
                        }
                    },
                    re_password: {
                        validators: {
                            notEmpty: {
                                message: 'Password is required'
                            },
                            stringLength: {
                                min: 6,
                                message: 'Password length must be atleast 6 characters'
                            },
                            identical: {
                                field: 'password',
                                message: 'The password must be same'
                            }
                        }
                    },
                    phone: {
                        validators: {
                            regexp: {
                                regexp: '^([0-9\(\)\/\+ \-]*)$',
                                message: 'Enter valid phone number'
                            },
                            notEmpty: {
                                message: 'Phone number is required'
                            }
                        }
                    }

                }
            });
        }
        function GiveAlert(){
            alert("You are successfully registered");
        }

    </script>


</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id= "regexpForm" class="sky-form" method="post" action="register">
                <header>Registration</header>

                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>User Name</label>
                                <label class="input">
                                    <input type="text" name="user_name" placeholder="User Name">
                                </label>
                            </div>
                        </section>

                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Email Address</label>
                                <label class="input">
                                    <input type="text" name="email" placeholder="Email Address">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Confirm Email Address</label>
                                <label class="input">
                                    <input type="text" name="co_email" placeholder="Confirm Email Address">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Password</label>
                                <label class="input">
                                    <input type="password" name="password" placeholder="Password">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Retype Password</label>
                                <label class="input">
                                    <input type="password" name="re_password" placeholder="Retype Password">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Contact Number</label>
                                <label class="input">
                                    <input type="text" name="phone" placeholder="Contact Number">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-8">
                            <div class="form-group">
                                <label>Date of Birth</label>
                                <label class="input">
                                    <input type="date" name="date" placeholder="Date of Birth">
                                </label>
                            </div>
                        </section>
                    </div>

                    <div class="row">
                        <section class="col col-6">
                            <button class="btn-u"  name="registration"  type="submit">Register</button>
                        </section>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
</div>


</body>
</html>
