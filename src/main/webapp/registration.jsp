<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="utf-8">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<section class="background-radial-gradient overflow-hidden">
    <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
        <div class="row gx-lg-5 align-items-center mb-5">

            <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                <div class="card bg-glass">
                    <div class="card-body px-4 py-5 px-md-5">
                        <form action="registration" method="post">

                            <div class="form-outline mb-4">
                                <input type="text" id="firstName" class="form-control" name="firstName"/>
                                <label class="form-label">First name</label>
                            </div>

                            <!-- Фамилия -->
                            <div class="form-outline mb-4">
                                <input type="text" id="lastName" class="form-control" name="lastName"/>
                                <label class="form-label">Last name</label>
                            </div>

                            <!-- Имя -->
                            <div class="form-outline mb-4">
                                <input type="email" id="email" class="form-control" name="email"/>
                                <label class="form-label">Email address</label>
                            </div>

                            <!-- Пароль -->
                            <div class="form-outline mb-4">
                                <input type="text" id="password" class="form-control" name="password"/>
                                <label class="form-label">password</label>
                            </div>

                            <!-- Номер -->
                            <div class="form-outline mb-4">
                                <input type="text" id="phoneNumber" class="form-control" name="phoneNumber"/>
                                <label class="form-label">Phone number</label>
                            </div>

                            <!-- Город -->
                            <div class="form-outline mb-4">
                                <input type="text" id="city" class="form-control" name="city"/>
                                <label class="form-label">City</label>
                            </div>

                            <!-- Город -->
                            <div class="form-outline mb-4">
                                <input type="text" id="address" class="form-control" name="address"/>
                                <label class="form-label">Address</label>
                            </div>

                            <!-- Номер дома -->
                            <div class="form-outline mb-4">
                                <input type="text" id="houseNumber" class="form-control" name="houseNumber"/>
                                <label class="form-label">House number</label>
                            </div>

                            <!-- Квартира -->
                            <div class="form-outline mb-4">
                                <input type="text" id="apartment" class="form-control" name="apartment"/>
                                <label class="form-label">Apartment</label>
                            </div>


                            <!-- Submit button -->
                            <div style="text-align: center;">
                                <button type="submit" class="btn btn-primary btn-block mb-4">
                                    Submit
                                </button>
                            </div>
                            <div style="text-align: center;">
                                <p style="color: red; font-weight: bold">${message}</p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script defer src="js/bootstrap.bundle.min.js"></script>
</body>
</html>