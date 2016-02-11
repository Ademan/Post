# Post
Csc668/868

#Getting Started
Clone reposority into your local development environment (Laptop or Desktop).

Use following Git Commands.
```
git clone https://github_url/repo.git
```
```
cd path/of/clone/repo
```
```
git fetch origin
```
To verify that `master` and `dev` branch are present.
```
git branch
```
To switch branches (excludes quotes).
```
git checkout "branch name"
```

#Branching 
Make sure you are in `dev` branch before branching out. ->`git branch`

Update `dev` branch.
```
git pull origin dev
```
Below makes and automatically switches to newly created branch.
```
git checkout -b name-of-branch
```
Happy Coding ;)

#Finalize.
After you have completed your task: 
- Push your final commits into your branch.
- Go to the Github repo.
- Make a new Pull request.
- Verify that base branch is Ademan/Post `dev` and merging with your `name-of-branch`.




