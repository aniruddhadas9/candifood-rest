				<!-- Content -->
					<div id="content">
						<div id="content-inner">
							<h1>Venders List</h1>
							<div>
								login=<a href="<s:property value="user.loginUrl"/>">Login</a><br>
								logout=<a href="<s:property value="user.logoutUrl"/>">Login</a><br>
								userId=<s:property value="user.iserId"/><br>
								name=<s:property value="user.name"/><br>
								email=<s:property value="user.email"/><br>
								nickname=<s:property value="user.nickname"/><br>
								authDomain=<s:property value="user.authDomain"/><br>
								federatedIdentity=<s:property value="user.federatedIdentity"/><br>
							
							</div>
							<p>
								<s:property value="vendorData"/>
							</p>
						</div>
					</div>

